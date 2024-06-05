package com.demo.demo_forum.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;

@Configuration
public class AppConfig {
  
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
  @Bean (name = "tempUserStorage")
  List<UserEntity> users() {
    return new ArrayList<>();
  }

  @Bean (name = "tempPostStorage")
  List<PostEntity> posts() {
    return new ArrayList<>();
  }

  @Bean (name = "tempCommentStorage")
  List<CommentEntity> comments() {
    return new ArrayList<>();
  }
}
