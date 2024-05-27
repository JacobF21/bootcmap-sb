package com.bootcamp.demo.democalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public interface DatabaseOperation {

  @RequestMapping(value = "/get")  
  String demoApi(int x);

  @GetMapping(value = "/sort")
  int[] sort();

  @GetMapping(value = "/descsort")
  int[] descSort();
  
}
