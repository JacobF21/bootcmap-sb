package com.demo.demo_defillama.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.demo.demo_defillama.controller.DefiLlamaOperation;
import com.demo.demo_defillama.dto.DataPointDTO;
import com.demo.demo_defillama.mapper.DataPointMapper;
import com.demo.demo_defillama.service.DefiLlamaService;

@RestController
public class DefiLlamaController implements DefiLlamaOperation{
  
  @Autowired
  DefiLlamaService defiLlamaService;

  @Autowired
  private DataPointMapper mapper;
  
  public List<DataPointDTO> getEthTvl(){
    return defiLlamaService.getEthTvl().stream()
          .map(e -> mapper.map(e)) //
          .collect(Collectors.toList());
  }
}
