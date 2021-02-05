// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.spark

import com.azure.cosmos.{CosmosAsyncClient, CosmosClientBuilder, ConsistencyLevel}
import com.azure.cosmos.implementation.{CosmosClientMetadataCachesSnapshot, SparkBridgeInternal}
import org.apache.spark.broadcast.Broadcast

import scala.collection.concurrent.TrieMap

private[spark] object CosmosClientCache {
    private val cache = new TrieMap[CosmosClientConfiguration, CosmosAsyncClient]

    private[spark] def apply(cosmosClientConfiguration: CosmosClientConfiguration,
              cosmosClientStateHandle: Option[Broadcast[CosmosClientMetadataCachesSnapshot]]): CosmosAsyncClient = {
        cache.get(cosmosClientConfiguration) match {
            case Some(client) => client
            case None =>
                var builder = new CosmosClientBuilder()
                    .key(cosmosClientConfiguration.key)
                    .endpoint(cosmosClientConfiguration.endpoint)
                    .userAgentSuffix(cosmosClientConfiguration.applicationName)

                if (cosmosClientConfiguration.useEventualConsistency){
                    builder = builder.consistencyLevel(ConsistencyLevel.EVENTUAL)
                }

                if (cosmosClientConfiguration.useGatewayMode){
                    builder = builder.gatewayMode()
                }

                cosmosClientStateHandle match {
                    case Some(handle) =>
                        val metadataCache = handle.value;
                        SparkBridgeInternal.setMetadataCacheSnapshot(builder, metadataCache)
                    case None => Unit
                }

                val client = builder.buildAsyncClient()

                cache.putIfAbsent(cosmosClientConfiguration, client) match {
                    case None =>
                        client
                    case Some(existingCosmosClient) =>
                        // Reuse the pre-existing one, means a concurrent thread put it first
                        client.close()
                        existingCosmosClient
                }
        }
    }

    private[spark] def purge(cosmosClientConfiguration: CosmosClientConfiguration): Unit = {
        cache.get(cosmosClientConfiguration) match {
            case None => Unit
            case Some(existingClient) =>
                cache.remove(cosmosClientConfiguration) match {
                    case None => Unit
                    case Some(_) => existingClient.close()
                }
        }
    }
}
