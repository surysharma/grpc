package com.thebigscale.unary.calculator.client;

import com.thebigscale.unary.calculator.CalculatorServiceGrpc;
import com.thebigscale.unary.calculator.SumRequest;
import com.thebigscale.unary.calculator.SumResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",
                50051)
                .usePlaintext()
                .build();

        //Sync client
        CalculatorServiceGrpc.CalculatorServiceBlockingStub calService =
                CalculatorServiceGrpc.newBlockingStub(channel);

        var num1 = 13;
        var num2 = 100;

        SumRequest sumRequest = SumRequest.newBuilder()
                .setNum1(num1)
                .setNum2(num2)
                .build();

        SumResponse sumResponse = calService.sum(sumRequest);

        System.out.println("Got the response " +  sumResponse.getSum());
        System.out.println("Shutting down channel");
        channel.shutdown();
    }
}
