package com.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.dto.CommentDTO;




@Component
public class CommentDTOMapper {
  
  public CommentDTO map(Comment comment){
    return CommentDTO.builder().commentId(comment.getCommentId())//
                      .name(comment.getName()).email(comment.getEmail())//
                      .body(comment.getBody()).build();
  }
}
