package com.thebigscale.unary.calculator.server;

import com.thebigscale.unary.calculator.CalculatorServiceGrpc;
import com.thebigscale.unary.calculator.SumRequest;
import com.thebigscale.unary.calculator.SumResponse;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {
    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        System.out.println("CalculatorServiceImpl received request...");
        //Get request
        long num1 = request.getNum1();
        long num2 = request.getNum2();

        //Create response
        SumResponse sumResponse = SumResponse.newBuilder()
                .setSum(num1 + num2)
                .build();

        //Send response
        responseObserver.onNext(sumResponse);

        //Finish the call.
        responseObserver.onCompleted();
    }
}
