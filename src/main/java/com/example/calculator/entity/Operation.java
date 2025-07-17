package com.example.calculator.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
public class Operation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "operation_type", nullable = false)
    private String operationType;
    
    @Column(name = "operand1", nullable = false)
    private Double operand1;
    
    @Column(name = "operand2", nullable = false)
    private Double operand2;
    
    @Column(name = "result", nullable = false)
    private Double result;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    // Constructors
    public Operation() {}
    
    public Operation(String operationType, Double operand1, Double operand2, Double result) {
        this.operationType = operationType;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.createdAt = LocalDateTime.now();
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
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}