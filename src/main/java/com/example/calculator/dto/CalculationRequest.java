package com.example.calculator.dto;

import jakarta.validation.constraints.NotNull;

public class CalculationRequest {
    
    @NotNull(message = "First operand cannot be null")
    private Double a;
    
    @NotNull(message = "Second operand cannot be null")
    private Double b;
    
    // Constructors
    public CalculationRequest() {}
    
    public CalculationRequest(Double a, Double b) {
        this.a = a;
        this.b = b;
    }
    
    // Getters and Setters
    public Double getA() { return a; }
    public void setA(Double a) { this.a = a; }
    
    public Double getB() { return b; }
    public void setB(Double b) { this.b = b; }
}
