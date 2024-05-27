package com.bootcamp.demo.democalculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.democalculator.DemoCalculatorApplication;
import com.bootcamp.demo.democalculator.controller.BeanOperation;

@Controller
@ResponseBody
public class BeanController implements BeanOperation{

  @Override
  public String[] getBeans() {
    return DemoCalculatorApplication.getContext().getBeanDefinitionNames();
  }
}
