package com.bootcamp.demo.democalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface CalculatorOperation {
  
  @GetMapping(value = "/sum/{x}+{y}")
  int sum(int x,int y);

  @GetMapping(value = "/substract/{salary}+{bonus}")
  int substract(int salary,int bonus);

  @GetMapping(value = "/multiply")
  int multiply(int x, int y);

  @GetMapping(value = "/divide/double")
  double divide(double x, double y);

  @GetMapping(value = "/sum/double")
  String sum2(String x, String y);


}
