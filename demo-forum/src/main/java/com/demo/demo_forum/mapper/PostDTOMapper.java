package com.demo.demo_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.dto.CommentDTO;
import com.demo.demo_forum.model.dto.PostDTO;

@Component
public class PostDTOMapper {
  public PostDTO map(Post post, List<CommentDTO> comments) {
    return PostDTO.builder()//
        .postId(post.getPostId())//
        .title(post.getTitle())//
        .body(post.getBody())//
        .comments(comments)//
        .build();
  }
}
