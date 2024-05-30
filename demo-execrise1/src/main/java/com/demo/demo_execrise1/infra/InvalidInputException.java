package com.demo.demo_execrise1.infra;

public class InvalidInputException extends BusinessException {
  public InvalidInputException() {
    super(SysCode.InvalidInput);
  }
}
