package com.demo.demo_sb_restful.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.demo.demo_sb_restful.entity.UserEntity;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
  List<UserEntity> findByEmail(String email);
  List<UserEntity> findByEmailLike(String email);

  //Order BY
  //Select specific fields?
  List<UserEntity> findByEmailLikeOrderByUsernameDesc(String email);

  //GroupBy, Having, Max,min,avg
  @Query("SELECT user_name FROM users GROUP BY user_name")
  List<UserEntity> countUsersByUserName();
}
