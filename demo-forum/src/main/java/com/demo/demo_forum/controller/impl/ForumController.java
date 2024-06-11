package com.demo.demo_forum.controller.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.demo_forum.controller.ForumOperation;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.infra.InvalidInputException;
import com.demo.demo_forum.infra.NotFoundException;
import com.demo.demo_forum.mapper.ApiResMapper;
import com.demo.demo_forum.mapper.CommentDTO2Mapper;
import com.demo.demo_forum.mapper.CommentDTOMapper;
import com.demo.demo_forum.mapper.CommentEntityMapper;
import com.demo.demo_forum.mapper.PostDTOMapper;
import com.demo.demo_forum.mapper.PostEntityMapper;
import com.demo.demo_forum.mapper.UserCommentDTOMapper;
import com.demo.demo_forum.mapper.UserDetailsDTOMapper;
import com.demo.demo_forum.mapper.UserEntityMapper;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.model.dto.ApiRes;
import com.demo.demo_forum.model.dto.CommentBodyDTO;
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

  @Autowired
  private CommentEntityMapper commentEntityMapper;

  @Autowired
  private ApiResMapper apiResMapper;

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

    public ApiRes<List<UserDetailsDTO>> getAllUser(){
      return apiResMapper.map(forumService.getAllUser());
    }

    public ApiRes<List<UserDetailsDTO>> getUserById(Long userId){
      return apiResMapper.map(List.of(userEntityMapper.map(forumService.getUserById(userId))));
    }

    public ApiRes<List<User>> updatUser(Long userId, User user){
      if(userId == user.getId()){
        return apiResMapper.map(List.of(forumService.updatUser(userId,user)));
      }
        //TO-DO
      throw new NotFoundException();
    }

    public ApiRes<List<Post>> getAllPost(){
      return apiResMapper.map(forumService.getAllPost().stream().map(postEntityMapper::map).collect(Collectors.toList()));
    }

    public ApiRes<List<Post>> getAllPostByUserId(Long userId){
      return apiResMapper.map(forumService.getAllPostByUserId(userId).stream().map(postEntityMapper::map).collect(Collectors.toList()));
    }

    public ApiRes<List<Post>> addPostByUserId(Long userId, Post post){
      if(userId == post.getUserId()){
        return apiResMapper.map(List.of(postEntityMapper.map(forumService.addPostByUserId(userId,post))));
      }
      throw new NotFoundException();
    }

    public ApiRes<List<Post>> deletePostByPostId(@PathVariable Long postId){
      return apiResMapper.map(List.of(postEntityMapper.map(forumService.deletePostByPostId(postId))));
    }

    public ApiRes<List<Comment>> getAllComment(){
      return apiResMapper.map((forumService.getAllComment().stream().map(commentEntityMapper::map).collect(Collectors.toList())));
    }

    public ApiRes<List<CommentDTO>> getCommentByPostId(Long postId){
      return apiResMapper.map(forumService.getCommetByPostId(postId));
    }

    public ApiRes<List<Comment>> addCommentByPostId(Long postId, Comment comment){
      return apiResMapper.map(List.of(forumService.addCommentByPostId(postId,comment)).stream().map(commentEntityMapper::map).collect(Collectors.toList()));
    }

    public ApiRes<List<Comment>> patchCommentByCommentId(Long commentId, CommentBodyDTO commentBodyDTO){
      return apiResMapper.map(List.of(commentEntityMapper.map(forumService.patchCommentByPostId(commentId,commentBodyDTO))));
    }


}
