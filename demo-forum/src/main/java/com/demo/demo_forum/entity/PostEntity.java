package com.demo.demo_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.ManyToAny;
import com.demo.demo_forum.entity.UserEntity.UserEntityBuilder;
import com.demo.demo_forum.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name ="Posts")
@Getter
@Setter
public class PostEntity implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String body;
  

  @ManyToOne
  @JoinColumn(name ="user_id") // DB table column name
  @JsonBackReference
  private UserEntity user; //object

  @OneToMany(mappedBy = "post" //
  ,cascade = CascadeType.MERGE)
@JsonManagedReference
private List<CommentEntity> comments = new ArrayList<>();

  //   @OneToMany(mappedBy = "post" //
  //     ,cascade = CascadeType.ALL)
  // @JsonManagedReference
  // private List<PostEntity> comments = new ArrayList<>();

  

}
