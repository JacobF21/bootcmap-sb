package com.demo.demo_forum.infra;

public class RestTemplateErrorException extends BusinessRuntimeException{
  public RestTemplateErrorException(){
    super(SysCode.REST_TEMPLATE);
  }
}
