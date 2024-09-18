package com.example.demo2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CurrencyConverterService implements ICurrencyConverterService {
    @Override
    public double convertToVND(double usdAmount, double exchangeRate){
        return usdAmount * exchangeRate;
    }
}
