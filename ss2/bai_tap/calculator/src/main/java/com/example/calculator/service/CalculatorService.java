package com.example.calculator.service;

import com.example.calculator.repository.ICalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Autowired
    private ICalculatorRepository calculatorRepository;

    @Override
    public double calculate(double first, double second, String operation) {
        return calculatorRepository.calculate(first, second, operation);
    }
}
