package com.demo.demo_execrise1.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demo.demo_execrise1.controller.CalculatorOperation;
import com.demo.demo_execrise1.dto.CalculatorDTO;
import com.demo.demo_execrise1.dto.ErrorDTO;
import com.demo.demo_execrise1.model.Operation;
import com.demo.demo_execrise1.service.CalculatorService;


@Controller
@ResponseBody
public class CalculatorController implements CalculatorOperation{
  
  @Autowired
  CalculatorService calculatorService;
  
  @Override
  public Object cal(String x,String y,String opt){
      try{
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
    } catch(NumberFormatException e){
      return new CalculatorDTO(x,y,opt,null);
    } catch(IllegalArgumentException e){
      return new ErrorDTO(9, "Invalid Input");
    } 
    return new CalculatorDTO();
  }
}

