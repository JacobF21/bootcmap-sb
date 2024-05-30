package com.demo.demo_execrise1.infra;

public class ArrayIndexOutOfBoundException extends BusinessException{
  public ArrayIndexOutOfBoundException() {
    super(SysCode.ArrayIndexOutOfBound);
  }
}
