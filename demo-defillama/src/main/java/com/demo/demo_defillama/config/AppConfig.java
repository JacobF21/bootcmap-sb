package com.demo.demo_defillama.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
