package com.demo.demo_forum.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiRes {
  private Long id;
  private String username;
  private List<CommentDTO> comments;
}
