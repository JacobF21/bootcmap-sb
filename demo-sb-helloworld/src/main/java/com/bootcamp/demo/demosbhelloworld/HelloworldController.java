package com.bootcamp.demo.demosbhelloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@ResponseBody
public class HelloworldController {
  
  //API Application Programming Interface
  @GetMapping(value ="/api/v1/helloworld") //URI -> resource identifier  
  public String hello(){
    return "Hello World";
  }

  @GetMapping(value ="/api/v2/jacob") //URI -> resource identifier  
  public String hello2(){
    return "Hello World2";
  }

  @GetMapping(value ="/api/v2/test")
  public String getMethodName(@RequestParam String param) {
      return new String();
  }
  
}
