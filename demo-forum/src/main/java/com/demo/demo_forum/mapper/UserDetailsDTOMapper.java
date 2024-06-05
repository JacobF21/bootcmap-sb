package com.demo.demo_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.model.dto.PostDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO.AddressDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO.CompanyDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO.AddressDTO.LocationDTO;

@Component
public class UserDetailsDTOMapper {
    public UserDetailsDTO map(User user,List<PostDTO> posts){
    
    LocationDTO locationDTO =LocationDTO.builder()
                                        .latitude(user.getAddress().getGeo().getLatitude())
                                        .longitude(user.getAddress().getGeo().getLongitude())
                                        .build();

    AddressDTO addressDTO = AddressDTO.builder()//
                                      .city(user.getAddress().getCity())
                                      .street(user.getAddress().getStreet())
                                      .suite(user.getAddress().getSuite())
                                      .geo(locationDTO)
                                      .build();

    CompanyDTO companyDTO = CompanyDTO.builder()
                                      .name(user.getCompany().getName())
                                      .business(user.getCompany().getBusiness())
                                      .build();
    
    return UserDetailsDTO.builder()
                         .id(user.getId())
                         .name(user.getName())
                         .username(user.getUsername())
                         .email(user.getEmail())
                         .phone(user.getPhone())
                         .website(user.getWebsite())
                         .address(addressDTO)
                         .company(companyDTO)
                         .posts(posts)
                         .build();
  }
}
