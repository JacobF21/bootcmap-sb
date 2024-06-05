package com.demo.demo_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.dto.UserCommentDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO;

public interface ForumOperation {
  @RequestMapping(value="/jsonplaceholder/add_users")
  public List<UserEntity> addUsers();

  @RequestMapping(value="/jsonplaceholder/add_posts")
  public List<PostEntity> addPost();

  @RequestMapping(value="/jsonplaceholder/add_comments")
  public List<CommentEntity> addComment();

  // @RequestMapping(value="/jsonplaceholder/get_comments")
  // public ApiRes getCommentsById(@RequestParam String userId);

  @RequestMapping(value="/jsonplaceholder/get_user")
  public List<UserDetailsDTO> getUserDetail();

  @RequestMapping(value="/jsonplaceholder/get_post_by_id")
  public List<Post> getPostById(String userId);

  @RequestMapping(value="/jsonplaceholder/get_comment_by_postId")
  public List<Comment> getCommentByPostId(String postId);

  @RequestMapping(value="/jsonplaceholder/get_comment_by_userId")
  public List<UserCommentDTO> getCommentByUserId(String userId);

}
