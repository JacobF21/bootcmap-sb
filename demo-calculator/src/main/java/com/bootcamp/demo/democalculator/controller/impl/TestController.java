package com.bootcamp.demo.democalculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.democalculator.config.AppConfig;
import com.bootcamp.demo.democalculator.config.AppConfig2;
import com.bootcamp.demo.democalculator.controller.TestOperation;
import com.bootcamp.demo.democalculator.model.Cat;


@Controller
@ResponseBody
public class TestController implements TestOperation{
  
  @Autowired// Find the appConfig object from spring context, and then inject to
  private AppConfig appConfig; //Null pointer exception(without Autowired)

  @Autowired(required = false)// Find the appConfig object from spring context, and then inject to
  private AppConfig2 appConfig2; //Null pointer exception(without Autowired)

  @Autowired
  @Qualifier(value = "white") 
  // inject the object by bean name
  private Cat cat;

  @Autowired
  @Qualifier(value = "blue") 
  // inject the object by bean name
  private Cat cat2;

  @Override
  public String testSayHello(){
    return new AppConfig().sayHello();
  }

  @Override
  public String testSayHello2(){
    //return appConfig.sayHello();//no @autowired npe
    System.out.println(appConfig.hashCode());
    System.out.println(appConfig2.hashCode());
    // if(appConfig == appConfig2){
    //   return "Yes";
    // }
    return "No";
  }

  @Override
  public String testSayHello3(){
    return new AppConfig2().sayHello();
  }

  @Override
  public Cat getWhiteCat(){
    return this.cat;
  }

  @Override
  public Cat getBlueCat(){
    System.out.println("cat2Blue");
    return this.cat2;
  }

}
