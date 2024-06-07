package com.demo.demo_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.demo.demo_forum.entity.CommentEntity;
import com.demo.demo_forum.entity.PostEntity;
import com.demo.demo_forum.model.dto.CommentDTO;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

      @Query("SELECT new com.demo.demo_forum.model.dto.CommentDTO(c.id, c.name, c.email, c.body) " +
           "FROM CommentEntity c WHERE c.post = :postId")
       List<CommentDTO> findCommentDTObyPostId(@Param("postId") PostEntity postId);
}

