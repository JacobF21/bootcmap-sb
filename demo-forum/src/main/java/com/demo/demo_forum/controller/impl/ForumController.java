package com.demo.demo_forum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.demo_forum.controller.ForumOperation;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.infra.InvalidInputException;
import com.demo.demo_forum.infra.NotFoundException;
import com.demo.demo_forum.mapper.CommentDTO2Mapper;
import com.demo.demo_forum.mapper.CommentDTOMapper;
import com.demo.demo_forum.mapper.PostDTOMapper;
import com.demo.demo_forum.mapper.PostEntityMapper;
import com.demo.demo_forum.mapper.UserCommentDTOMapper;
import com.demo.demo_forum.mapper.UserDetailsDTOMapper;
import com.demo.demo_forum.mapper.UserEntityMapper;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.model.dto.ApiRes;
import com.demo.demo_forum.model.dto.CommentDTO;
import com.demo.demo_forum.model.dto.CommentDTO2;
import com.demo.demo_forum.model.dto.PostDTO;
import com.demo.demo_forum.model.dto.UserCommentDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO;
import com.demo.demo_forum.service.ForumService;

@RestController
public class ForumController implements ForumOperation {

  @Autowired
  private ForumService forumService;

  @Autowired
  private CommentDTOMapper commentDTOMapper;

  @Autowired
  private CommentDTO2Mapper commentDTO2Mapper;

  @Autowired
  private PostDTOMapper postDTOMapper;

  @Autowired
  private UserDetailsDTOMapper userDetailsDTOMapper;

  @Autowired
  private UserCommentDTOMapper userCommentDTOMapper;

  @Autowired
  private UserEntityMapper userEntityMapper;

  @Autowired
  private PostEntityMapper postEntityMapper;

  @Override
  public List<UserEntity> addUsers() {
    return forumService.addUsers();
  }

  @Override
  public List<PostEntity> addPost() {
    return forumService.addPost();
  }

  @Override
  public List<CommentEntity> addComment() {
    return forumService.addComments();
  }

  // @Override
  // public ApiRes getCommentsById(String userId){
  // return forumService.getCommentsById(Long.parseLong(userId));
  // }

  @Override
  public List<UserDetailsDTO> getUserDetail() {
    List<User> users = forumService.getUser();
    List<UserDetailsDTO> userDetailsList = users.stream().map(user -> {
      List<PostDTO> postList =
          forumService.getPost(user.getId()).stream().map(post -> {
            List<CommentDTO> commentList =
                forumService.getComment(post.getPostId()).stream()
                    .map(commentDTOMapper::map).collect(Collectors.toList());
            return postDTOMapper.map(post, commentList);
          }).collect(Collectors.toList());
      return userDetailsDTOMapper.map(user, postList);
    }).collect(Collectors.toList());
    return userDetailsList;
  }

  public List<Post> getPostById(String userId) {
    if (!userId.matches("\\d+")) {
      throw new InvalidInputException();
    }
    if (forumService.getUser().stream()
        .filter(e -> e.getId() == Long.parseLong(userId))
        .collect(Collectors.toList()).size() != 0) {
      return forumService.getPost(Long.parseLong(userId));
    }
    throw new NotFoundException();

  }

  public List<Comment> getCommentByPostId(String postId) {
    return forumService.getComment(Long.parseLong(postId));
  }

  public List<UserCommentDTO> getCommentByUserId(String userId) {
    if (!userId.matches("\\d+")) {
      throw new InvalidInputException();
    }
    if (forumService.getUser().stream()
        .filter(e -> e.getId() == Long.parseLong(userId))
        .collect(Collectors.toList()).size() == 0) {
      throw new NotFoundException();
    }
    User user = forumService.getUser().stream()//
        .filter(e -> e.getId() == Long.parseLong(userId))//
        .findFirst().orElse(null);

    return forumService.getPost(Long.parseLong(userId)).stream().map(e -> {
      List<CommentDTO2> commentList = forumService.getComment(e.getPostId())
          .stream().map(commentDTO2Mapper::map).collect(Collectors.toList());
      return userCommentDTOMapper.map(user, commentList);
    }).collect(Collectors.toList());
  }

    public List<UserEntity> getAllUser(){
      return forumService.getAllUser();
    }

    public User getUserById(String userId){
      return userEntityMapper.map(forumService.getUserById(Long.parseLong(userId)));
    }

    public User updatUser(String userId, User user){
      if(userId.equals(user.getId().toString())){
        return forumService.updatUser(Long.parseLong(userId),user);
      }
        //TO-DO
      throw new NotFoundException();
    }

    public List<Post> getAllPost(){
      return forumService.getAllPost().stream().map(postEntityMapper::map).collect(Collectors.toList());
    }
}
