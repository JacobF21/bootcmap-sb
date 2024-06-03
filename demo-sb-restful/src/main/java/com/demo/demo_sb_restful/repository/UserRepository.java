package com.demo.demo_sb_restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.demo_sb_restful.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
