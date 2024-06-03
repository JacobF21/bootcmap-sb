package com.demo.demo_defillama.mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import org.springframework.stereotype.Component;
import com.demo.demo_defillama.dto.DataPointDTO;
import com.demo.demo_defillama.model.DataPoint;

@Component
public class DataPointMapper {
  public DataPointDTO map(DataPoint dp){
    LocalDate localDate = Instant.ofEpochSecond(dp.getDate())
    .atZone(ZoneId.systemDefault())
    .toLocalDate();

    return DataPointDTO.builder() //
          .localDate(localDate)  //
          .tvl(dp.getTvl()) //
          .build(); 
  }
}
