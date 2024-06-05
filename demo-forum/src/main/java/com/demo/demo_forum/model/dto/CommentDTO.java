package com.demo.demo_forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentDTO {
  private Long commentId;
  private String name;
  private String email;
  private String body;
}
