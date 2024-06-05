package com.demo.demo_forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.demo_forum.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long>{
  // @Query("SELECT p.id FROM PostEntity p WHERE p.userId = :userId")
  // List<Long> getPostIdByUserId(@Param("userId") Long userId);
}
