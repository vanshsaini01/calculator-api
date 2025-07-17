package com.example.calculator.repository;

import com.example.calculator.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByOperationTypeIgnoreCase(String operationType);
}
