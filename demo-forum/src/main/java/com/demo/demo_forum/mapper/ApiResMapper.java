package com.demo.demo_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.demo.demo_forum.infra.SysCode;
import com.demo.demo_forum.model.dto.ApiRes;

@Component
public class ApiResMapper<T> {
  
  public ApiRes<T> map(List<T> data){
    return ApiRes.<T>builder().code(SysCode.OK.getCode().toString())
          .message(SysCode.OK.getDesc()).data(data).build();
  }
}
