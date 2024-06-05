package com.demo.demo_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.model.dto.CommentDTO2;
import com.demo.demo_forum.model.dto.UserCommentDTO;

@Component
public class UserCommentDTOMapper {
  public UserCommentDTO map(User user, List<CommentDTO2> comments){
      return UserCommentDTO.builder().id(user.getId())//
                           .name(user.getName())//
                           .comments(comments).build();
  }
}
