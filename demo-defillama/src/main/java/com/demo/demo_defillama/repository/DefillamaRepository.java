package com.demo.demo_defillama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.demo_defillama.entity.DataPointEntity;


@Repository // bean
//Hibernate (JobsDB)
//Generate the class implementing this JPA interface
public interface DefillamaRepository extends JpaRepository<DataPointEntity,Long>{
  

}
