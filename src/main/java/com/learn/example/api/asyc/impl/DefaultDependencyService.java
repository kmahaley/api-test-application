package com.learn.example.api.asyc.impl;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.learn.example.api.asyc.DependencyService;
import org.springframework.stereotype.Service;

/**
 * Taken reference from https://www.callicoder.com/java-8-completablefuture-tutorial/
 *
 * @author km185223
 */
@Service
public class DefaultDependencyService implements DependencyService {

    @Override
    public void testCompletableFuturesApi() throws Exception {

        Supplier<String> stringSupplier = () -> "Hello World !!";
        Supplier<Double> doubleSupplier = () -> 62.66;
        Supplier<Boolean> booleanSupplier = () -> true;
        Consumer<Double> consumer = weight -> String.format("Weight of Jim is %d", weight);

        final CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(stringSupplier);
        System.out.println(supplyAsync.get());

        CompletableFuture<String> chainThenApply = supplyAsync
                .thenApply(str -> str.length())
                .thenApply(length -> String.format("Length of string is %s", length));

        System.out.println(chainThenApply.get());

        CompletableFuture
                .supplyAsync(doubleSupplier)
                .thenApply(weight -> weight * 100)
                .thenAccept(load -> System.out.println("Tractor takes "+ load+" kg of load"));
    }

    @Override
    public void testCompletableFuturesApiWithExecutors() throws Exception {
        Executor executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> "Result of the asynchronous computation", executor);

        System.out.println(future.get());
    }
}
