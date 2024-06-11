package com.demo.demo_forum.infra;

import lombok.Getter;

@Getter
public enum SysCode {
  OK(0,"success."),// 
  NOT_FOUND(1,"User not found"),
  INVALID_INPUT(2,"Invalid Input"),
  REST_TEMPLATE(3,"RestTemplate Error - JSONPlaceHolder")
  ;

  private Integer code;
  private String desc;

  private SysCode(int code,String desc){
    this.code=code;
    this.desc=desc;
  }
}
