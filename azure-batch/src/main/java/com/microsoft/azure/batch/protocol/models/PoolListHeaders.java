/**
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.batch.protocol.models;

import com.microsoft.rest.DateTimeRfc1123;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines headers for List operation.
 */
public class PoolListHeaders {
    /**
     * Gets the ClientRequestId provided by the client during the request, if
     * present and requested to be returned.
     */
    @JsonProperty(value = "client-request-id")
    private String clientRequestId;

    /**
     * Gets the value that uniquely identifies a request.
     */
    @JsonProperty(value = "request-id")
    private String requestId;

    /**
     * Gets the content of the ETag HTTP response header.
     */
    @JsonProperty(value = "ETag")
    private String eTag;

    /**
     * Gets the content of the Last-Modified HTTP response header.
     */
    @JsonProperty(value = "Last-Modified")
    private DateTimeRfc1123 lastModified;

    /**
     * Get the clientRequestId value.
     *
     * @return the clientRequestId value
     */
    public String getClientRequestId() {
        return this.clientRequestId;
    }

    /**
     * Set the clientRequestId value.
     *
     * @param clientRequestId the clientRequestId value to set
     */
    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    /**
     * Get the requestId value.
     *
     * @return the requestId value
     */
    public String getRequestId() {
        return this.requestId;
    }

    /**
     * Set the requestId value.
     *
     * @param requestId the requestId value to set
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * Get the eTag value.
     *
     * @return the eTag value
     */
    public String getETag() {
        return this.eTag;
    }

    /**
     * Set the eTag value.
     *
     * @param eTag the eTag value to set
     */
    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    /**
     * Get the lastModified value.
     *
     * @return the lastModified value
     */
    public DateTime getLastModified() {
        if (this.lastModified == null) {
            return null;
        }
        return this.lastModified.getDateTime();
    }

    /**
     * Set the lastModified value.
     *
     * @param lastModified the lastModified value to set
     */
    public void setLastModified(DateTime lastModified) {
        this.lastModified = new DateTimeRfc1123(lastModified);
    }

}
