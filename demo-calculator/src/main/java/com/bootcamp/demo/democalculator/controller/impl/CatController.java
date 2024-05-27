package com.bootcamp.demo.democalculator.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.democalculator.controller.CatOperation;
import com.bootcamp.demo.democalculator.model.Cat;
import com.bootcamp.demo.democalculator.model.Color;

// @Controller
// @ResponseBody
@RestController
public class CatController implements CatOperation{

  // Java method returns Java object (Cat)
  // Spring Boot web layer (serialization - from java object to json)
  @Override
  public Cat test() {
    return new Cat("ABC", 13, List.of(Color.ORANGE, Color.BLUE));
  }

  // API return List<Cat>
  @Override
  public List<Cat> catTest() {
    return new ArrayList<>(
        List.of(new Cat("Vincent", 3, List.of(Color.WHITE, Color.BLUE)),
            new Cat("Jason", 10, List.of(Color.BLACK))));
  }

  // API return Cat[]
  @Override
  public Cat[] catArrayTest() {
    return new Cat[] {new Cat("Karson", 3, List.of(Color.WHITE)),
        new Cat("Jenny", 2, List.of(Color.ORANGE, Color.BLUE))};
  }
}
