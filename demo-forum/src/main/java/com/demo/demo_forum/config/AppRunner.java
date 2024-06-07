package com.demo.demo_forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.demo.demo_forum.repository.UserRepository;
import com.demo.demo_forum.service.ForumService;

@Component
public class AppRunner implements CommandLineRunner {
  
  @Autowired
  ForumService forumService;

  @Autowired
  UserRepository userRepository;
  
  //AppRunner bean already exists in Context after server start

  //run() will be executed by Spring before completed server start process
  @Override
  public void run(String... args){
    if(userRepository.count() == 0){
      forumService.addUsers();
      forumService.addPost();
      forumService.addComments();
    }  
    //throw new RuntimeException();
  }
}
