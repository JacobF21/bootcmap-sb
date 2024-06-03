package com.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.demo_sb_restful.dto.UserDTO;
import com.demo.demo_sb_restful.entity.UserEntity;
import com.demo.demo_sb_restful.model.dto.User;


public interface UserOperation {
  
  @RequestMapping(value="/jsonplaceholder/users")
  public List<UserDTO> getUsers();

  @RequestMapping(value="/jsonplaceholder/add_users")
  public List<User> addUsers();

  @RequestMapping(value="/jsonplaceholder/remove_users")
  public List<User> removeUsers(@RequestParam int userId);

  @RequestMapping(value="/jsonplaceholder/remove_users2")
  public List<User> removeUsers2(@RequestParam int userId);

  @RequestMapping(value="/jsonplaceholder/get_users")
  public List<User> getUsers2();

  @PostMapping(value="/user")
  UserEntity saveUser(@RequestBody UserEntity user);

}
