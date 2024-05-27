package com.demo.demo_sb_dto.model;

import lombok.*;

@AllArgsConstructor
@Getter
public class Stock {
  private int id;
  private String description;  
  private int quantity;
}
