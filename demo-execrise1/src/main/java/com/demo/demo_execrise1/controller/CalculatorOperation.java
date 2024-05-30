package com.demo.demo_execrise1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.demo.demo_execrise1.dto.CalculatorDTO;
import com.demo.demo_execrise1.model.Input;

public interface CalculatorOperation {
  @GetMapping(value = "/{x}+{y}+{opt}")
  CalculatorDTO cal(@PathVariable(value="x")String x,@PathVariable(value="y")String y, @PathVariable(value="opt")String opt);

  @PostMapping(value = "/demo")
  CalculatorDTO cal2(@RequestBody Input input);
  
}
