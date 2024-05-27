package com.demo.demo_execrise1.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.demo.demo_execrise1.service.CalculatorService;

@Service
public class CalculatorImpl implements CalculatorService{
  
  @Override
  public String add(String x, String y){
    return Double.toString(BigDecimal.valueOf(Double.parseDouble(x)).add(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue());
  }

  @Override
  public String sub(String x, String y){
    return Double.toString(BigDecimal.valueOf(Double.parseDouble(x)).subtract(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue());
  }

  @Override
  public String mul(String x, String y){
    return Double.toString(BigDecimal.valueOf(Double.parseDouble(x)).multiply(BigDecimal.valueOf(Double.parseDouble(y))).doubleValue());
  }

  @Override
  public String div(String x, String y){
    return Double.toString(BigDecimal.valueOf(Double.parseDouble(x)).divide(BigDecimal.valueOf(Double.parseDouble(y)),5,RoundingMode.HALF_UP).doubleValue());
  }
}
