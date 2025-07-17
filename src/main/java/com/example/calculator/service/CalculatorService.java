package com.example.calculator.service;

import com.example.calculator.dto.CalculationRequest;
import com.example.calculator.dto.CalculationResponse;
import com.example.calculator.entity.Operation;
import com.example.calculator.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CalculatorService {

    @Autowired
    private OperationRepository operationRepository;

    public CalculationResponse performAndSave(CalculationRequest request, String type) {
        double result = 0.0;
        boolean success = true;
        String message = type + " completed successfully";

        switch (type.toLowerCase()) {
            case "add" -> result = request.getA() + request.getB();
            case "subtract" -> result = request.getA() - request.getB();
            case "multiply" -> result = request.getA() * request.getB();
            case "divide" -> {
                if (request.getB() == 0) {
                    return new CalculationResponse(false, type, request.getA(), request.getB(), null, "Division by zero not allowed");
                }
                result = request.getA() / request.getB();
            }
            default -> {
                success = false;
                message = "Invalid operation type";
            }
        }

        if (!success) {
            return new CalculationResponse(false, type, request.getA(), request.getB(), null, message);
        }

        Operation op = new Operation();
        op.setOperand1(request.getA());
        op.setOperand2(request.getB());
        op.setResult(result);
        op.setOperationType(type.toLowerCase());
        op.setCreatedAt(LocalDateTime.now());
        operationRepository.save(op);

        return new CalculationResponse(true, type, request.getA(), request.getB(), result, message);
    }
}
