package com.demo.demo_forum.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Comment {
  private Long postId;
  @JsonProperty(value = "id")
  private Long commentId;
  private String name;
  private String email;
  private String body;
}
