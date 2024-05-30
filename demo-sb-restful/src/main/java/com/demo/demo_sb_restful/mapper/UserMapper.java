package com.demo.demo_sb_restful.mapper;

import org.springframework.stereotype.Component;
import com.demo.demo_sb_restful.dto.UserDTO;
import com.demo.demo_sb_restful.dto.UserDTO.AddressDTO;
import com.demo.demo_sb_restful.dto.UserDTO.AddressDTO.LocationDTO;
import com.demo.demo_sb_restful.dto.UserDTO.CompanyDTO;
import com.demo.demo_sb_restful.model.dto.User;

@Component
public class UserMapper {

  public UserDTO map(User user) {

    LocationDTO locationDTO = LocationDTO.builder() //
        .latitude(user.getAddress().getGeo().getLatitude())
        .longitude(user.getAddress().getGeo().getLongitude()).build();

    AddressDTO addressDTO = AddressDTO.builder() //
        .city(user.getAddress().getCity()) //
        .street(user.getAddress().getStreet()) //
        .suite(user.getAddress().getSuite()) //
        .geo(locationDTO) //
        .build();

    CompanyDTO companyDTO = CompanyDTO.builder() //
        .name(user.getCompany().getName()) //
        .business(user.getCompany().getBusiness()) //
        .build();

    return UserDTO.builder() //
        .id(user.getId()) //
        .name(user.getName()) //
        .address(addressDTO) //
        .company(companyDTO) //
        .build();
  }
}

