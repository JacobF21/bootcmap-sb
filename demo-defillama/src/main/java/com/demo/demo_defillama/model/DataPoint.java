package com.demo.demo_defillama.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataPoint {
  private long date;
  private long tvl;
}
