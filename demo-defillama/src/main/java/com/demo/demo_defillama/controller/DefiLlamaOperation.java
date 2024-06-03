package com.demo.demo_defillama.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.demo.demo_defillama.dto.DataPointDTO;

public interface DefiLlamaOperation {
  @GetMapping(value="eth_tvl")
  List<DataPointDTO> getEthTvl();

}
