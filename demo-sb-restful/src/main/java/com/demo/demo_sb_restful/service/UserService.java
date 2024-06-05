package com.demo.demo_sb_restful.service;

import java.util.List;
import com.demo.demo_sb_restful.entity.UserEntity;
import com.demo.demo_sb_restful.model.dto.User;
import com.demo.demo_sb_restful.requestDto.UserReqDTO;

public interface UserService {
    List<User> getUsers(); 
    List<User> addUsers();
    List<User> removeUsers(int userId);
    List<User> removeUsers2(int userId);
    List<User> getUsers2();
    UserEntity save(UserEntity user);
    UserEntity deleteById(Long id);
    UserEntity updateUser(Long id, UserEntity user);
    List<UserEntity> getByEmail(String email);
    UserEntity updateUserEmailById(Long id, UserReqDTO userReqDTO);


}
