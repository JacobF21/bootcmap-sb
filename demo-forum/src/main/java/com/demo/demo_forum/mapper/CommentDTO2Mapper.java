package com.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.dto.CommentDTO2;

@Component
public class CommentDTO2Mapper {
    public CommentDTO2 map(Comment comment){
    return CommentDTO2.builder().name(comment.getName())//
                      .email(comment.getEmail())//
                      .body(comment.getBody()).build();
  }
}
