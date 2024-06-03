package com.demo.demo_sb_restful.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.demo.demo_sb_restful.infra.SysCode;
import com.demo.demo_sb_restful.model.dto.User;

@Configuration
public class AppConfig {
  
  //WebClient
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
  @Bean (name = "tempStorage")
  List<User> users() {
    return new ArrayList<>();
  }

}
