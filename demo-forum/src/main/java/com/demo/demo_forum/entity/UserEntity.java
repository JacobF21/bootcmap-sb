package com.demo.demo_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements Serializable {
  
  @Id // Table Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment
  private Long id;
  private String name;
  @Column(name="user_name")
  private String username;
  private String email;
  private String phone;
  private String website;
  //private AddressDTO address;
  @Column(name="addr_street")
  private String street;
  @Column(name="addr_suite")
  private String suite;
  @Column(name="addr_city")
  private String city;
  @Column(name="addr_zipcode")
  private String zipcode;
  @Column(name="addr_lat")
  private String lat;
  @Column(name="addr_long")
  private String lng;
  //private CompanyDTO company;
  @Column(name="company_name")
  private String companyName;
  @Column(name="company_catchphrase")
  private String companyCatchPhrase;
  @Column(name="company_business")
  private String companyBusiness;

  @OneToMany(mappedBy = "user" //
      ,cascade = CascadeType.MERGE)
  @JsonManagedReference
  private List<PostEntity> posts = new ArrayList<>();

  // @OneToMany(cascade = CascadeType.PERSIST)
  // @JoinColumn(name="user_id")
  // private List<PostEntity> posts = new ArrayList<>();

}

