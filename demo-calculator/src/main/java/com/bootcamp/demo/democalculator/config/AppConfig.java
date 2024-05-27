package com.bootcamp.demo.democalculator.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.bootcamp.demo.democalculator.model.Cat;
import com.bootcamp.demo.democalculator.model.Color;

@Configuration // new AppConfig() -> Spring Context
public class AppConfig {
  
  //private String name;

  public String sayHello(){
    return "hello";
  }

  @Bean (name="white")//Create an object(bean), and then put it into spring context
  Cat createWhiteCat(){
    return new Cat("ABC",3,List.of(Color.WHITE));
  }

  @Bean (name = "blue")
  //@Primary Approach1
  Cat createBlueCat(){
    return new Cat("DEF",4,List.of(Color.BLUE));
  }
}
