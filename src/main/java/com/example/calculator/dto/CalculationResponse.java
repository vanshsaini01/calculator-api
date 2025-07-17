package com.example.calculator.dto;

import java.time.LocalDateTime;

public class CalculationResponse {
    
    private boolean success;
    private String operation;
    private Double operand1;
    private Double operand2;
    private Double result;
    private String message;
    private LocalDateTime timestamp;
    
    // Constructors
    public CalculationResponse() {}
    
    public CalculationResponse(boolean success, String operation, Double operand1, 
                              Double operand2, Double result, String message) {
        this.success = success;
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    
    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
    
    public Double getOperand1() { return operand1; }
    public void setOperand1(Double operand1) { this.operand1 = operand1; }
    
    public Double getOperand2() { return operand2; }
    public void setOperand2(Double operand2) { this.operand2 = operand2; }
    
    public Double getResult() { return result; }
    public void setResult(Double result) { this.result = result; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
