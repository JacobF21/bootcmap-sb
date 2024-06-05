package com.demo.demo_forum.infra;

public class InvalidInputException extends BusinessRuntimeException{
  
  public InvalidInputException(){
    super(SysCode.INVALID_INPUT);
  }
}
