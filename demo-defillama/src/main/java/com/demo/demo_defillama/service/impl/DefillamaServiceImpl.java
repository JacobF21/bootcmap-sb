package com.demo.demo_defillama.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.demo.demo_defillama.infra.Scheme;
import com.demo.demo_defillama.model.DataPoint;
import com.demo.demo_defillama.service.DefiLlamaService;

@Service
public class DefillamaServiceImpl implements DefiLlamaService{
  
  @Value(value = "${api.defillama.domain}") // required = true
  private String domain;

  @Value(value = "${api.defillama.endpoints.ethereum}")
  private String ethEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<DataPoint> getEthTvl(){
    String url = UriComponentsBuilder.newInstance() //
    .scheme(Scheme.HTTPS.lowercase()) // 
    .host(this.domain) //
    .path(this.ethEndpoint) //
    .build(false)//
    .toUriString(); 

    System.out.println("url=" + url);

    DataPoint[] dataPoint = restTemplate.getForObject(url, DataPoint[].class);
    return Arrays.asList(dataPoint);
  }
  
}
