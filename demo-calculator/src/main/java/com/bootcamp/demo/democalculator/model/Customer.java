package com.bootcamp.demo.democalculator.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Customer {
  private String name; // same as the field name in JSON
  private LocalDate joinDate; // same as the field name in JSON
  private List<Order> orders; // same as the field name in JSON

}
