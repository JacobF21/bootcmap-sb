package com.demo.demo_execrise1.infra;

public class IllegalArgumentException extends BusinessException {
  public IllegalArgumentException() {
    super(SysCode.IllegalArgument);
  }
}
