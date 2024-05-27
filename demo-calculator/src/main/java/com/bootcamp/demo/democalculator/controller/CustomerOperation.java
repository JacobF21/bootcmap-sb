package com.bootcamp.demo.democalculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.democalculator.model.Customer;

public interface CustomerOperation {
  
  @GetMapping(value="/customers")
  List<Customer> getAll();
}
