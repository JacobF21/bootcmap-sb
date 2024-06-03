package com.demo.demo_sb_restful.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {

  private int id;
  private String name;
  private String username;
  private String email;
  private AddressDTO address;
  private String phone;
  private String website;
  private CompanyDTO company;

  @Getter
  @Builder
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
    // private String zipcode;
    private LocationDTO geo;

    @Getter
    @Builder
    public static class LocationDTO {
      private String latitude;
      private String longitude;
    }
  }

  @Getter
  @Builder
  public static class CompanyDTO {
    private String name;
    // private String catchPhrase;
    @JsonProperty(value = "bss")
    private String business;
  }
}

  

