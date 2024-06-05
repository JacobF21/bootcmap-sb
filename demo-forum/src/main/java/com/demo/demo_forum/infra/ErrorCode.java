package com.demo.demo_forum.infra;

import lombok.Getter;

@Getter
public enum ErrorCode {
  NOT_FOUND(1,"User not found"),
  INVALID_INPUT(2,"Invalid Input"),
  REST_TEMPLATE(3,"RestTemplate Error - JSONPlaceHolder")
  ;


  private int code;
  private String desc;

  private ErrorCode(int code, String desc){
    this.code=code;
    this.desc=desc;
  }
}
