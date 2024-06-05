package com.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.model.User;

@Component
public class UserEntityMapper {
  
  public UserEntity map(User user){
    return UserEntity.builder().city(user.getAddress().getCity())
                        .street(user.getAddress().getStreet())
                        .suite(user.getAddress().getSuite())
                        .zipcode(user.getAddress().getZipcode())
                        .lat(user.getAddress().getGeo().getLatitude())
                        .lng(user.getAddress().getGeo().getLongitude())
                        .companyBusiness(user.getCompany().getBusiness())
                        .companyCatchPhrase(user.getCompany().getCatchPhrase())
                        .companyName(user.getCompany().getName())
                        .email(user.getEmail())
                        .name(user.getName())
                        .phone(user.getPhone())
                        .username(user.getUsername())
                        .website(user.getWebsite())
                        .build();
  } 
}
