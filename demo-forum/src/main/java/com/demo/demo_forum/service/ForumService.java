package com.demo.demo_forum.service;

import java.util.List;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.model.dto.ApiRes;
import com.demo.demo_forum.model.dto.CommentBodyDTO;
import com.demo.demo_forum.model.dto.CommentDTO;


public interface ForumService {
  public List<UserEntity> addUsers();
  public List<PostEntity> addPost();
  public List<CommentEntity> addComments();
  // public ApiRes getCommentsById(Long userId);
  public List<User> getUser();
  public List<Post> getPost(Long userId);
  public List<Comment> getComment(Long postId);
  public List<CommentDTO> getCommetByPostId(Long postId);
  public List<PostEntity> getPostByUserId(Long userId);
  public List<UserEntity> getAllUser();
  public UserEntity getUserById(Long userId);
  public User updatUser(Long userId, User user);
  public List<PostEntity> getAllPost();
  public List<PostEntity> getAllPostByUserId(Long userId);
  public PostEntity addPostByUserId(Long userId, Post post);
  public PostEntity deletePostByPostId(Long postId);
  public List<CommentEntity> getAllComment();
  public CommentEntity addCommentByPostId(Long postId, Comment comment);
  public CommentEntity patchCommentByPostId(Long postId, CommentBodyDTO commentBodyDTO);
}
