package com.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.model.User.Address;
import com.demo.demo_forum.model.User.Company;
import com.demo.demo_forum.model.User.Address.Location;

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

  public User map(UserEntity userEntity){
    Location location = Location.builder().latitude(userEntity.getLat())
                                .longitude(userEntity.getLng()).build();

    Address address = Address.builder().street(userEntity.getStreet())//
                             .suite(userEntity.getSuite()).city(userEntity.getCity())//
                             .zipcode(userEntity.getZipcode()).geo(location)
                             .build();

   Company company = Company.builder().name(userEntity.getCompanyName())
                            .catchPhrase(userEntity.getCompanyCatchPhrase())
                            .business(userEntity.getCompanyBusiness())
                            .build();
    
    return User.builder().id(userEntity.getId()).name(userEntity.getName())//
               .username(userEntity.getName()).email(userEntity.getEmail())//
               .address(address).phone(userEntity.getPhone())
               .website(userEntity.getWebsite()).company(company)//
               .build();
  }
}
