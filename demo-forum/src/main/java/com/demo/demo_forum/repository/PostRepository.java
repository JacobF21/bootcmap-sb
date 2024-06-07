package com.demo.demo_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.dto.PostDTO;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long>{
  // @Query("SELECT p.id FROM PostEntity p WHERE p.userId = :userId")
  // List<Long> getPostIdByUserId(@Param("userId") Long userId);

  @Query("SELECT p FROM PostEntity p WHERE p.user = :userId")
  List<PostEntity> findPostbyUserId(@Param("userId") UserEntity userId);

}
