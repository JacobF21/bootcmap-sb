package com.demo.demo_forum.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;


@Entity
@Table(name ="Posts")
@Getter
public class PostEntity {
  @Id
  private Long id;
  private Long userId;
  private String title;
  private String body;
}
