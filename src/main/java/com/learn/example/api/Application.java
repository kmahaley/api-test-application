/*
 * -----------------------------------------------------------------------------
 *  Copyright 2018 NCR Corporation
 * -----------------------------------------------------------------------------
 */
package com.learn.example.api;

import com.learn.example.api.asyc.DependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author km185223
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private DependencyService dependencyService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        dependencyService.testCompletableFuturesApi();
    }
}
