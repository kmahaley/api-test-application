/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */
package com.learn.example.api.asyc;

/**
 * Service to call function asynchronously
 *
 * @author km185223
 */
public interface DependencyService {

    /**
     * Api to test all completableFuture
     */
    void testCompletableFuturesApi() throws Exception;

    /**
     * Completable future Api with Executors
     */
    void testCompletableFuturesApiWithExecutors() throws Exception;
}
