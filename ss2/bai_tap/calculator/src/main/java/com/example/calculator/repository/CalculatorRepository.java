package com.example.calculator.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepository implements ICalculatorRepository {
    @Override
    public double calculate(double first, double second, String operation) {
        switch (operation) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                if (second == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return first / second;
        }
        return 0;
    }
}
