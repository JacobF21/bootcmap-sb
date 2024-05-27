package com.bootcamp.demo.democalculator.controller.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.democalculator.controller.CalculatorOperation;

@Controller
@ResponseBody
public class CalculatorController implements CalculatorOperation{
  

  //@PathVariable is a way to map the variable in the URI to java method input parameters
  @Override
  public int sum(@PathVariable(value="x")int salary,@PathVariable(value="y")int bonus){
    return salary+bonus;
  }

  //We can achieve default mapping by name, if you do not explicitly define Path variable value
  @Override
  public int substract(@PathVariable int salary,@PathVariable int bonus){
    return salary-bonus;
  }

  @Override
  public int multiply(@RequestParam(value = "a")int quantity, @RequestParam(value="b") int price){
    return quantity*price;
  }

  @Override
  public double divide(@RequestParam(value = "a")double quantity, @RequestParam(value="b") double price){
    return BigDecimal.valueOf(quantity).divide(BigDecimal.valueOf(price)).doubleValue();
  }

  @Override
  public String sum2(@RequestParam String q, @RequestParam String p){
    double p2 = 0.0d;
    double q2 = 0.0d;
    try{
      q2=Double.parseDouble(q);
      p2=Double.parseDouble(p);
    } catch(NumberFormatException e){
      return "Both q and p should be numbers.";
    }
    return BigDecimal.valueOf(p2).add(BigDecimal.valueOf(q2)).toString();
  }

}
