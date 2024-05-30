package com.demo.demo_execrise1.infra;

public class NumberFormatException extends BusinessException{
  public NumberFormatException() {
    super(SysCode.NumberFormat);
  }
}
