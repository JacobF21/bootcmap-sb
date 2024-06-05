package com.demo.demo_forum.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentDTO2 {
  private String name;
  private String email;
  private String body;
}
