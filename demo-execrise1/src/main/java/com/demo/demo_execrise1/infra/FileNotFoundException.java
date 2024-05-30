package com.demo.demo_execrise1.infra;

public class FileNotFoundException extends BusinessException{
  public FileNotFoundException() {
    super(SysCode.FileNotFound);
  }
}
