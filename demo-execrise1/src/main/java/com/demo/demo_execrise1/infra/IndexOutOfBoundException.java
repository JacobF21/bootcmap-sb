package com.demo.demo_execrise1.infra;

public class IndexOutOfBoundException extends BusinessException {
  public IndexOutOfBoundException() {
    super(SysCode.IndexOutOfBound);
  }
}
