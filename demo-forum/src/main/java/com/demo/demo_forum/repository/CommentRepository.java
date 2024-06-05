package com.demo.demo_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.demo_forum.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

  @Query(
      value = "SELECT * FROM Comments c WHERE c.post_id IN (SELECT p.id FROM Posts p WHERE p.user_Id = :userId)",
      nativeQuery = true)
  List<CommentEntity> findCommentsByUserId(@Param("userId") Long userId);


}
