package com.demo.demo_forum.infra;

public class NotFoundException extends BusinessRuntimeException{
  public NotFoundException(){
    super(SysCode.NOT_FOUND);
  }
}
