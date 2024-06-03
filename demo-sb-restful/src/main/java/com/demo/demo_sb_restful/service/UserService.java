package com.demo.demo_sb_restful.service;

import java.util.List;
import com.demo.demo_sb_restful.entity.UserEntity;
import com.demo.demo_sb_restful.model.dto.User;

public interface UserService {
    List<User> getUsers(); 
    List<User> addUsers();
    List<User> removeUsers(int userId);
    List<User> removeUsers2(int userId);
    List<User> getUsers2();
    UserEntity save(UserEntity user);


}
