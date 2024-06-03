package com.demo.demo_defillama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name ="TVL")
@Getter
public class DataPointEntity {
 
  @Id
  private Long date;
  @Column(name="tvl")
  private long tvl;
}
