package com.demo.demo_forum.infra;

public class BusinessRuntimeException extends RuntimeException{
  
  private int code;

  public BusinessRuntimeException(SysCode sysCode){
    super(sysCode.getDesc());
    this.code=sysCode.getCode();
  }
}
