package com.demo.demo_execrise1.infra;

public class NullPointerException extends BusinessException {
  public NullPointerException() {
    super(SysCode.NullPointer);
  }
}
