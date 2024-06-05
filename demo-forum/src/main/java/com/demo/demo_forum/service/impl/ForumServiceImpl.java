package com.demo.demo_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.infra.Scheme;
import com.demo.demo_forum.mapper.UserEntityMapper;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.repository.CommentRepository;
import com.demo.demo_forum.repository.PostRepository;
import com.demo.demo_forum.repository.UserRepository;
import com.demo.demo_forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

@Service
public class ForumServiceImpl implements ForumService{
  @Value(value = "${api.json-place-holder.domain}") // required = true
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String usersEndpoint;

  @Value(value = "${api.json-place-holder.endpoints.posts}")
  private String postsEndpoint;

  @Value(value = "${api.json-place-holder.endpoints.comments}")
  private String commentsEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  @Qualifier("tempUserStorage")
  private List<UserEntity> users;

  @Autowired
  @Qualifier("tempPostStorage")
  private List<PostEntity> posts;

  @Autowired
  @Qualifier("tempCommentStorage")
  private List<CommentEntity> comments;

  @Autowired
  private UserEntityMapper userEntityMapper;

  
  @Override  
  public List<UserEntity> addUsers(){
    String url =
    UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.lowercase())
                        .host(this.domain).path(this.usersEndpoint)
                        .toUriString();
    User[] tempUsers = restTemplate.getForObject(url, User[].class);
    for(int i=0;i<tempUsers.length;i++){
      users.add(userEntityMapper.map(tempUsers[i]));
    }
    for(UserEntity user:users){
      userRepository.save(user);
    }
    return users;
  }

  @Override  
  public List<PostEntity> addPost(){
    String url = UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.lowercase())
                                    .host(this.domain).path(this.postsEndpoint)
                                    .toUriString();
    PostEntity[] tempPosts = restTemplate.getForObject(url, PostEntity[].class);
    posts.addAll(Arrays.asList(tempPosts));
    for(PostEntity post:posts){
        postRepository.save(post);
    }
    return posts;                         
  }

  @Override
  public List<CommentEntity> addComment(){
    String url = UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.lowercase())
                                      .host(this.domain).path(this.commentsEndpoint)
                                      .toUriString();
    CommentEntity[] tempComments = restTemplate.getForObject(url, CommentEntity[].class);
    comments.addAll(Arrays.asList(tempComments));
    for(CommentEntity comment:comments){
        commentRepository.save(comment);
    }
    return comments; 
  }

  // @Override
  // public ApiRes getCommentsById(Long userId){
  //   Optional<UserEntity> userEntity = userRepository.findById(userId);
  //   String username ="";
  //   List<CommentDTO> comment = new ArrayList<>();
  //   if (userEntity.isPresent()) {
  //     username=userEntity.get().getUsername();
  //   } 
  //   List<CommentEntity> result = commentRepository.findCommentsByUserId(userId);
  //   for(CommentEntity ce : result){
  //     comment.add(commentDTOMapper.map(ce));
  //   }
  //   return ApiRes.builder().id(userId).username(username).comments(comment).build();
  // }

  @Override
  public List<User> getUser(){
    String url =
    UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.lowercase())
                        .host(this.domain).path(this.usersEndpoint)
                        .toUriString();
    User[] tempUsers = restTemplate.getForObject(url, User[].class);
    return Arrays.asList(tempUsers);
  }

  @Override
  public List<Post> getPost(Long userId){
    String url =
    UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.lowercase())
                        .host(this.domain).path(this.postsEndpoint)
                        .toUriString();
    Post[] tempPosts = restTemplate.getForObject(url, Post[].class);
    return Arrays.stream(tempPosts).filter(e-> e.getUserId() == userId).collect(Collectors.toList());
  }

  @Override
  public List<Comment> getComment(Long postId){
    String url =
    UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.lowercase())
                        .host(this.domain).path(this.commentsEndpoint)
                        .toUriString();
    Comment[] tempComments = restTemplate.getForObject(url, Comment[].class);
    return Arrays.stream(tempComments).filter(e->e.getPostId()==postId).collect(Collectors.toList());
  }

}
