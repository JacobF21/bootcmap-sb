package com.bootcamp.demo.democalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Order {
  private int id;
  private Address address;
}
