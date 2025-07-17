package com.example.calculator.dto;
import java.time.LocalDateTime;

import java.util.List;

public class OperationHistoryResponse {
    
    private boolean success;
    private List<Operation> data;
    private int count;
    private String message;
    
    // Constructors
    public OperationHistoryResponse() {}
    
    public OperationHistoryResponse(boolean success, List<Operation> data, String message) {
        this.success = success;
        this.data = data;
        this.count = data != null ? data.size() : 0;
        this.message = message;
    }
    
    // Getters and Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    
    public List<Operation> getData() { return data; }
    public void setData(List<Operation> data) { 
        this.data = data; 
        this.count = data != null ? data.size() : 0;
    }
    
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    // Inner class for cleaner response
    public static class Operation {
        private Long id;
        private String operationType;
        private Double operand1;
        private Double operand2;
        private Double result;
        private LocalDateTime createdAt;
        
        // Constructors
        public Operation() {}
        
        public Operation(Long id, String operationType, Double operand1, 
                        Double operand2, Double result, LocalDateTime createdAt) {
            this.id = id;
            this.operationType = operationType;
            this.operand1 = operand1;
            this.operand2 = operand2;
            this.result = result;
            this.createdAt = createdAt;
        }
        
        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        
        public String getOperationType() { return operationType; }
        public void setOperationType(String operationType) { this.operationType = operationType; }
        
        public Double getOperand1() { return operand1; }
        public void setOperand1(Double operand1) { this.operand1 = operand1; }
        
        public Double getOperand2() { return operand2; }
        public void setOperand2(Double operand2) { this.operand2 = operand2; }
        
        public Double getResult() { return result; }
        public void setResult(Double result) { this.result = result; }
        
        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    }
}