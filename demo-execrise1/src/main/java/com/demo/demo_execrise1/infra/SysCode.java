package com.demo.demo_execrise1.infra;

import lombok.Getter;

@Getter
public enum SysCode {
  OK(0, "success."), //
  NOT_FOUND(1, "not found."), //
  InvalidInput(2,"InvalidInput"),
  NumberFormat(3,"NumberFormat"),
  Arithmetic(4,"ArithmeticException"),
  NullPointer(5,"NullPointerException"),
  ClassCascade(6,"ClassCascadeException"),
  IndexOutOfBound(7,"IndexOutOfBoundException"),
  IllegalArgument(8,"IllegalArgumentException"),
  ArrayIndexOutOfBound(9,"ArrayIndexOutOfBound"),
  StringIndexOutOfBound(10,"StringIndexOutOfBound"),
  FileNotFound(11,"FileNotFound"),
  ;

  private int code;
  private String desc;

  private SysCode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }
}

