package com.demo.demo_sb_restful.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import com.demo.demo_sb_restful.entity.UserEntity;
import com.demo.demo_sb_restful.infra.NotFoundException;
import com.demo.demo_sb_restful.infra.Scheme;
import com.demo.demo_sb_restful.model.dto.User;
import com.demo.demo_sb_restful.repository.UserRepository;
import com.demo.demo_sb_restful.requestDto.UserReqDTO;
import com.demo.demo_sb_restful.service.UserService;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
  @Value(value = "${api.json-place-holder.domain}") // required = true
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String usersEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  // Spring will generate
  @Autowired
  private UserRepository userRepository;

  @Autowired
  @Qualifier("tempStorage")
  private List<User> users;

  @Override
  public List<User> getUsers() {
    // RestTemplate
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowercase()) // https or http
        .host(this.domain) //
        .path(this.usersEndpoint) //
        .toUriString(); // handle "://"

    System.out.println("url=" + url);

    User[] users = restTemplate.getForObject(url, User[].class);
    // new RestTemplate().getForObject
    // 1. call API, and get json result
    // 2. Convert json result to java object (User[].class)
    return Arrays.asList(users);
  }

  public List<User> addUsers() {
    String url =
        UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.lowercase())
            .host(this.domain).path(this.usersEndpoint).toUriString();
    User[] tempUsers = restTemplate.getForObject(url, User[].class);
    users.addAll(Arrays.asList(tempUsers));
    return users;
  }

  // when looping the list users, if we remove one of the user in the list the for-each loop still searching the list but the size is reduced
  public List<User> removeUsers(int userId) {
    for (User user : users) {
      if (user.getId() == userId) {
        users.remove(user);
      }
    }
    return users;
  }

  public List<User> removeUsers2(int userId) {
    users.removeIf(user -> user.getId() == userId);
    return users;
  }

  public List<User> getUsers2() {
    return this.users;
  }

  @Override
  public UserEntity save(UserEntity user) {
    return userRepository.save(user);
  }

  @Override
  public UserEntity deleteById(Long id) {
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()) {
      userRepository.deleteById(id);
      return userEntity.get();
    }
    // return null;
    throw new NotFoundException();
  }

  @Override
  public UserEntity updateUser(Long id, UserEntity user) {
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()) {
      // UserEntity existingUserEntity = userEntity.get();
      // existingUserEntity.update(user);
      user.setId(id);
      return userRepository.saveAndFlush(user);

      // return userRepository.save(existingUserEntity);
    }
    // return null;
    throw new NotFoundException();
  }

  @Override
  public List<UserEntity> getByEmail(String email) {
    //return userRepository.findByEmailLike("%"+email+"%");
    //return userRepository.findByEmailLikeOrderByUsernameDesc("%"+email+"%");
    return userRepository.countUsersByUserName();
  }

  @Override
  public UserEntity updateUserEmailById(Long id, UserReqDTO dto) {
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if(userEntity.isPresent()){
      UserEntity entity = userEntity.get();
      entity.setEmail(dto.getEmail());
      userRepository.save(entity);
      return entity;
    }
    throw new NotFoundException();
  }
}
