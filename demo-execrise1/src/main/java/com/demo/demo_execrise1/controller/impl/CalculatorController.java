package com.demo.demo_execrise1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demo.demo_execrise1.controller.CalculatorOperation;
import com.demo.demo_execrise1.dto.CalculatorDTO;
import com.demo.demo_execrise1.model.Input;
import com.demo.demo_execrise1.model.Operation;
import com.demo.demo_execrise1.service.CalculatorService;


@Controller
@ResponseBody
public class CalculatorController implements CalculatorOperation{
  
  @Autowired
  CalculatorService calculatorService;
  
  @Override
  public CalculatorDTO cal(String x,String y,String opt){
  
      Operation tempOpt = Operation.valueOf(opt.toUpperCase());
      if(tempOpt==Operation.ADD){
        String result = calculatorService.add(x, y);
        return new CalculatorDTO(x, y, opt,result);
      } else if(tempOpt==Operation.SUB){
        String result = calculatorService.sub(x, y);
        return new CalculatorDTO(x,y,opt,result);
      } else if(tempOpt==Operation.MUL){
        String result = calculatorService.mul(x, y);
        return new CalculatorDTO(x,y,opt,result);
      } else if(tempOpt==Operation.DIV){
        String result = calculatorService.div(x, y);
        return new CalculatorDTO(x,y,opt,result);
      }
      return new CalculatorDTO();
  }

  @Override
  public CalculatorDTO cal2(Input input){
    Operation tempOpt = Operation.valueOf(input.getOpt().toUpperCase());
    if(tempOpt==Operation.ADD){
      String result = calculatorService.add(input.getX(), input.getY());
      return new CalculatorDTO(input.getX(), input.getY(), input.getOpt(),result);
    } else if(tempOpt==Operation.SUB){
      String result = calculatorService.sub(input.getX(), input.getY());
      return new CalculatorDTO(input.getX(), input.getY(), input.getOpt(),result);
    } else if(tempOpt==Operation.MUL){
      String result = calculatorService.mul(input.getX(), input.getY());
      return new CalculatorDTO(input.getX(), input.getY(), input.getOpt(),result);
    } else if(tempOpt==Operation.DIV){
      String result = calculatorService.div(input.getX(), input.getY());
      return new CalculatorDTO(input.getX(), input.getY(), input.getOpt(),result);
    }
    return new CalculatorDTO();
  }
}

