/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.costmanagement.v2019_11_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.costmanagement.v2019_11_01.implementation.CostManagementManager;
import com.microsoft.azure.management.costmanagement.v2019_11_01.implementation.QueryResultInner;
import java.util.List;
import java.util.Map;

/**
 * Type representing QueryResult.
 */
public interface QueryResult extends HasInner<QueryResultInner>, HasManager<CostManagementManager> {
    /**
     * @return the columns value.
     */
    List<QueryColumn> columns();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the nextLink value.
     */
    String nextLink();

    /**
     * @return the rows value.
     */
    List<List<Object>> rows();

    /**
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * @return the type value.
     */
    String type();

}
