package com.demo.demo_forum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name ="Comments")
@Getter
public class CommentEntity {
  @Id
  private Long id;
  private Long postId;
  private String name;
  private String email;
  @Column(length = 500)
  private String body;
}
