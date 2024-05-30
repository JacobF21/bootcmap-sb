package com.demo.demo_sb_restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.demo.demo_sb_restful.config.AppConfig;
import com.demo.demo_sb_restful.controller.UserOperation;
import com.demo.demo_sb_restful.dto.UserDTO;
import com.demo.demo_sb_restful.mapper.UserMapper;
import com.demo.demo_sb_restful.model.dto.User;
import com.demo.demo_sb_restful.service.UserService;

@RestController
@RequestMapping(value = "/v1")
public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper mapper;

  @Override
  public List<UserDTO> getUsers() {
    return userService.getUsers().stream() //
        .map(e -> mapper.map(e)) //
        .collect(Collectors.toList());
  }

  public List<User> addUsers(){
    return userService.addUsers();
  }

  public List<User> removeUsers(int userId){
    return userService.removeUsers(userId);
  }

  public List<User> removeUsers2(int userId){
    return userService.removeUsers2(userId);
  }

  public List<User> getUsers2(){
    return userService.getUsers2();
  }

}