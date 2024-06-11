package com.demo.demo_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
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

  @RequestMapping(value="/jsonplaceholder/get_all_user")
  public ApiRes<List<UserDetailsDTO>> getAllUser();

  @RequestMapping(value="/jsonplaceholder/get_user_by_id")
  public ApiRes<List<UserDetailsDTO>>  getUserById(@RequestParam Long userId);

  @PutMapping(value="/jsonplaceholder/update_user_by_id")
  public ApiRes<List<User>> updatUser(@RequestParam Long userId, @RequestBody User user);

  @RequestMapping(value="/jsonplaceholder/get_all_post")
  public ApiRes<List<Post>> getAllPost();

  @RequestMapping(value="/jsonplaceholder/get_all_post_by_user_id/{userId}")
  public ApiRes<List<Post>> getAllPostByUserId(@PathVariable Long userId);

  @PostMapping(value="/jsonplaceholder/add_post_by_user_id/{userId}")
  public ApiRes<List<Post>> addPostByUserId(@PathVariable Long userId, @RequestBody Post post);

  @DeleteMapping(value="/jsonplaceholder/delete_post_by_post_id/{postId}")
  public ApiRes<List<Post>> deletePostByPostId(@PathVariable Long postId);

  @RequestMapping(value="/jsonplaceholder/get_all_comment")
  public ApiRes<List<Comment>> getAllComment();

  @RequestMapping(value="/jsonplaceholder/get_comment_by_post_id")
  public ApiRes<List<CommentDTO>> getCommentByPostId(@RequestParam Long postId);

  @PatchMapping(value="/jsonplaceholder/patch_comment_by_comment_id")
  public ApiRes<List<Comment>> patchCommentByCommentId(@RequestParam Long commentId, @RequestBody CommentBodyDTO commentBodyDTO);

}
