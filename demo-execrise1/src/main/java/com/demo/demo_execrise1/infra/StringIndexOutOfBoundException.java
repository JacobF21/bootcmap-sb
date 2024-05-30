package com.demo.demo_execrise1.infra;

public class StringIndexOutOfBoundException extends BusinessException {
  public StringIndexOutOfBoundException() {
    super(SysCode.StringIndexOutOfBound);
  }
}
