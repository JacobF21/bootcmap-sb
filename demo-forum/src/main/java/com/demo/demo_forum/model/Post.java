package com.demo.demo_forum.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Post {
  
  private Long userId;
  @JsonProperty(value = "id")
  private Long postId;
  private String title;
  private String body;
}
