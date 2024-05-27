package com.demo.demo_execrise1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.demo.demo_execrise1.dto.CalculatorDTO;
import com.demo.demo_execrise1.model.Operation;

public interface CalculatorOperation {
  @GetMapping(value = "/{x}+{y}+{opt}")
  Object cal(@PathVariable(value="x")String x,@PathVariable(value="y")String y, @PathVariable(value="opt")String opt);

}
