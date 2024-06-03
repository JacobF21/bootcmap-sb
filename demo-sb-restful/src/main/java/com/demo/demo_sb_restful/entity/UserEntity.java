package com.demo.demo_sb_restful.entity;

import com.demo.demo_sb_restful.dto.UserDTO.AddressDTO;
import com.demo.demo_sb_restful.dto.UserDTO.CompanyDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;


//JPA will generate the DDL (Create Table) by the definition in Entity Class
@Entity
@Table(name ="Users")
@Getter
public class UserEntity {
  
  @Id // Table Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment
  private Long id;
  @Column(name="name")
  private String name;
  @Column(name="user_name")
  private String username;
  private String email;
  private String phone;
  private String website;
  //private AddressDTO address;
  @Column(name="addr_street")
  private String addrStreet;
  @Column(name="addr_suite")
  private String addrSuite;
  @Column(name="addr_city")
  private String addrCity;
  @Column(name="addr_zipcode")
  private String addrZipcode;
  @Column(name="addr_lat")
  private String addrlatitude;
  @Column(name="addr_long")
  private String addrlongitude;
  //private CompanyDTO company;
  @Column(name="company_name")
  private String companyName;
  @Column(name="company_catchphrase")
  private String companyCatchPhrase;
  @Column(name="company_business")
  private String companyBusiness;

}
