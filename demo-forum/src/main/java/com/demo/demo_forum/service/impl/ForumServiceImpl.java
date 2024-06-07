package com.demo.demo_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.infra.Scheme;
import com.demo.demo_forum.mapper.CommentEntityMapper;
import com.demo.demo_forum.mapper.PostEntityMapper;
import com.demo.demo_forum.mapper.UserEntityMapper;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.model.dto.CommentDTO;
import com.demo.demo_forum.model.dto.CommentDTO2;
import com.demo.demo_forum.model.dto.PostDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO;
import com.demo.demo_forum.repository.CommentRepository;
import com.demo.demo_forum.repository.PostRepository;
import com.demo.demo_forum.repository.UserRepository;
import com.demo.demo_forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import com.demo.demo_forum.infra.NotFoundException;


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

  @Autowired
  private PostEntityMapper postEntityMapper;

  @Autowired
  private CommentEntityMapper commentEntityMapper;

  
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
    Post[] tempPosts = restTemplate.getForObject(url, Post[].class);
    PostEntity[] tempPostEntity = new PostEntity[tempPosts.length];
    for(int i=0;i<tempPosts.length;i++){
      tempPostEntity[i]=postEntityMapper.map(tempPosts[i]);
    }
    posts.addAll(Arrays.asList(tempPostEntity));
    for(PostEntity post:posts){
        postRepository.save(post);
    }
    return posts;                         
  }

  @Override
  public List<CommentEntity> addComments(){
    String url = UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.lowercase())
                                      .host(this.domain).path(this.commentsEndpoint)
                                      .toUriString();
    Comment[] tempComments = restTemplate.getForObject(url, Comment[].class);
    CommentEntity[] tempCommentEntitiy = new CommentEntity[tempComments.length];
    for(int i=0;i<tempComments.length;i++){
      tempCommentEntitiy[i]=commentEntityMapper.map(tempComments[i]);
    }
    comments.addAll(Arrays.asList(tempCommentEntitiy));
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

  @Override
  public List<CommentDTO> getCommetByPostId(Long postId){
    PostEntity pe=new PostEntity();
    pe.setId(postId);
    return commentRepository.findCommentDTObyPostId(pe);
  }

  @Override
  public List<PostEntity> getPostByUserId(Long userId){
    UserEntity ue = new UserEntity();
    ue.setId(userId);
    return postRepository.findPostbyUserId(ue);
  }

  @Override
  public List<UserEntity> getAllUser(){
    return userRepository.findAll();
  }

  @Override
  public UserEntity getUserById(Long userId){
    Optional<UserEntity> userEntity = userRepository.findById(userId);
    if(userEntity.isPresent()){
      return userEntity.get();
    }
    throw new NotFoundException();
  }

  @Override
  public User updatUser(Long userId, User user){
    Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
    if(optionalUserEntity.isPresent()){
      UserEntity userEntity = optionalUserEntity.get();
      userEntity.setName(user.getName());
      userEntity.setUsername(user.getUsername());
      userEntity.setEmail(user.getEmail());
      userEntity.setPhone(user.getPhone());
      userEntity.setWebsite(user.getWebsite());
      userEntity.setStreet(user.getAddress().getStreet());
      userEntity.setSuite(user.getAddress().getSuite());
      userEntity.setCity(user.getAddress().getCity());
      userEntity.setZipcode(user.getAddress().getZipcode());
      userEntity.setLat(user.getAddress().getGeo().getLatitude());
      userEntity.setLng(user.getAddress().getGeo().getLongitude());
      userEntity.setCompanyName(user.getCompany().getName());
      userEntity.setCompanyCatchPhrase(user.getCompany().getCatchPhrase());
      userEntity.setCompanyBusiness(user.getCompany().getBusiness());
      userRepository.save(userEntity);
      return user;
    }
    throw new NotFoundException();
  }

  public List<PostEntity> getAllPost(){
    return postRepository.findAll();
  }



}
