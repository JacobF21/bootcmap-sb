package com.demo.demo_forum.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCommentDTO {
  private Long id;
  private String name;
  private List<CommentDTO2> comments;
}
