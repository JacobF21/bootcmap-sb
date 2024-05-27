package com.bootcamp.demo.democalculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
public class PersonController {
  
  @GetMapping("path")
  public String getMethodName(@RequestParam String param) {
      return new String();
  }
  
}
