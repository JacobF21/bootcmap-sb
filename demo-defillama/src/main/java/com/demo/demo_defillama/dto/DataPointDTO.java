package com.demo.demo_defillama.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DataPointDTO {
  private LocalDate localDate;
  private long tvl;
}
