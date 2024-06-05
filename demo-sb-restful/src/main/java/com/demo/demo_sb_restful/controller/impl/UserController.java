package com.demo.demo_sb_restful.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.demo_sb_restful.controller.UserOperation;
import com.demo.demo_sb_restful.dto.UserDTO;
import com.demo.demo_sb_restful.entity.UserEntity;
import com.demo.demo_sb_restful.infra.ApiResp;
import com.demo.demo_sb_restful.infra.SysCode;
import com.demo.demo_sb_restful.infra.ApiResp.ApiRespBuilder;
import com.demo.demo_sb_restful.mapper.UserMapper;
import com.demo.demo_sb_restful.model.dto.User;
import com.demo.demo_sb_restful.requestDto.UserReqDTO;
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

  @Override
  public UserEntity saveUser(UserEntity user){
    return userService.save(user);
  }

  @Override
  public UserEntity deleteUser(Long id){
    return userService.deleteById(id);
  }

  @Override
  public ApiResp updateUser(Long id, UserEntity user){
    UserEntity temp=userService.updateUser(id, user);
    List<UserEntity> result = new ArrayList<>();
    result.add(temp);
    return new ApiRespBuilder().withData(result).withId(SysCode.OK.getCode()).withMessage(SysCode.OK.getDesc()).build();
  }

  @Override
  public List<UserEntity> getByEmail(String email){
    return userService.getByEmail(email);
  }

  @Override
  public UserEntity updateUserEmailById(Long id,UserReqDTO userReqDTO){
    return userService.updateUserEmailById(id, userReqDTO);
  }
}
