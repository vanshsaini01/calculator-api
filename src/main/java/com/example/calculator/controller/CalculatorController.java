package com.example.calculator.controller;

import com.example.calculator.dto.CalculationRequest;
import com.example.calculator.dto.CalculationResponse;
import com.example.calculator.entity.Operation;
import com.example.calculator.repository.OperationRepository;
import com.example.calculator.service.CalculatorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Validated
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private OperationRepository operationRepository;

    // ✅ POST APIs (store in DB)
    @PostMapping("/add")
    public ResponseEntity<CalculationResponse> add(@Valid @RequestBody CalculationRequest request) {
        return ResponseEntity.ok(calculatorService.performAndSave(request, "add"));
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculationResponse> subtract(@Valid @RequestBody CalculationRequest request) {
        return ResponseEntity.ok(calculatorService.performAndSave(request, "subtract"));
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculationResponse> multiply(@Valid @RequestBody CalculationRequest request) {
        return ResponseEntity.ok(calculatorService.performAndSave(request, "multiply"));
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculationResponse> divide(@Valid @RequestBody CalculationRequest request) {
        return ResponseEntity.ok(calculatorService.performAndSave(request, "divide"));
    }

    // ✅ GET API with optional filter
    @GetMapping("/operations")
    public ResponseEntity<Map<String, Object>> getOperations(@RequestParam(required = false) String type) {
        List<Operation> operations;
        if (type == null || type.isEmpty()) {
            operations = operationRepository.findAll();
        } else {
            operations = operationRepository.findByOperationTypeIgnoreCase(type);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("count", operations.size());
        response.put("data", operations);
        return ResponseEntity.ok(response);
    }

    // ✅ Health check
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "API is running");
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.ok(response);
    }
}
