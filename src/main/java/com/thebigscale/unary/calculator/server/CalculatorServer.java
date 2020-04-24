package com.thebigscale.unary.calculator.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CalculatorServer {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Inside server...");

        final Server server = ServerBuilder.forPort(50051)
                .addService(new CalculatorServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    System.out.println("Shutdown request...");
                    server.shutdown();
                    System.out.println("Successfully Shutdown...");
                })
        );

        server.awaitTermination();

    }
}
