package com.demo.demo_execrise1.infra;

public class ArithmeticException extends BusinessException{

    public ArithmeticException() {
      super(SysCode.Arithmetic);
    }
    
}
