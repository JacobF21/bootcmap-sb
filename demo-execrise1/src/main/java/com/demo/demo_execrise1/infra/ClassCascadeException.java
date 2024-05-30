package com.demo.demo_execrise1.infra;

public class ClassCascadeException extends BusinessException{
  public ClassCascadeException() {
    super(SysCode.ClassCascade);
  }
}
