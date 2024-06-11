package com.demo.demo_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.demo_forum.entity.UserEntity;
import com.demo.demo_forum.model.User;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    // @Query("Select u FROM UserEntity u")
    // List<UserEntity> findAllUser();

    List<UserEntity> findAllByOrderById();
}
