package com.demo.demo_forum.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDTO {
  private Long postId;
  private String title;
  private String body;
  private List<CommentDTO> comments;
}
