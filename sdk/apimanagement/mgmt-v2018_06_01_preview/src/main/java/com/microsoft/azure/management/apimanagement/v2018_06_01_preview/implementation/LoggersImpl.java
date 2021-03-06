/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * jkl
 */

package com.microsoft.azure.management.apimanagement.v2018_06_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.apimanagement.v2018_06_01_preview.Loggers;
import rx.Completable;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.apimanagement.v2018_06_01_preview.LoggerContract;

class LoggersImpl extends WrapperImpl<LoggersInner> implements Loggers {
    private final ApiManagementManager manager;

    LoggersImpl(ApiManagementManager manager) {
        super(manager.inner().loggers());
        this.manager = manager;
    }

    public ApiManagementManager manager() {
        return this.manager;
    }

    @Override
    public LoggerContractImpl define(String name) {
        return wrapModel(name);
    }

    private LoggerContractImpl wrapModel(LoggerContractInner inner) {
        return  new LoggerContractImpl(inner, manager());
    }

    private LoggerContractImpl wrapModel(String name) {
        return new LoggerContractImpl(name, this.manager());
    }

    @Override
    public Observable<LoggerContract> listByServiceAsync(final String resourceGroupName, final String serviceName) {
        LoggersInner client = this.inner();
        return client.listByServiceAsync(resourceGroupName, serviceName)
        .flatMapIterable(new Func1<Page<LoggerContractInner>, Iterable<LoggerContractInner>>() {
            @Override
            public Iterable<LoggerContractInner> call(Page<LoggerContractInner> page) {
                return page.items();
            }
        })
        .map(new Func1<LoggerContractInner, LoggerContract>() {
            @Override
            public LoggerContract call(LoggerContractInner inner) {
                return new LoggerContractImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable getEntityTagAsync(String resourceGroupName, String serviceName, String loggerId) {
        LoggersInner client = this.inner();
        return client.getEntityTagAsync(resourceGroupName, serviceName, loggerId).toCompletable();
    }

    @Override
    public Observable<LoggerContract> getAsync(String resourceGroupName, String serviceName, String loggerId) {
        LoggersInner client = this.inner();
        return client.getAsync(resourceGroupName, serviceName, loggerId)
        .map(new Func1<LoggerContractInner, LoggerContract>() {
            @Override
            public LoggerContract call(LoggerContractInner inner) {
                return new LoggerContractImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String serviceName, String loggerId, String ifMatch) {
        LoggersInner client = this.inner();
        return client.deleteAsync(resourceGroupName, serviceName, loggerId, ifMatch).toCompletable();
    }

}
