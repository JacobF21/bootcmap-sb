package com.demo.demo_defillama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.demo_defillama.entity.DataPointEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public interface DefillamaRepository extends JpaRepository<DataPointEntity,Long>{
  

}
