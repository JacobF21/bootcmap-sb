package com.demo.demo_forum.service;

import java.util.List;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.User;

public interface ForumService {
  public List<UserEntity> addUsers();
  public List<PostEntity> addPost();
  public List<CommentEntity> addComment();
  // public ApiRes getCommentsById(Long userId);
  public List<User> getUser();
  public List<Post> getPost(Long userId);
  public List<Comment> getComment(Long postId);
}
