package com.demo.demo_sb_dto.model;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
  private int id;
  private List<Stock> stocks;

  public User(){
    this.id++;
    this.stocks=new ArrayList<>();
  }
}
