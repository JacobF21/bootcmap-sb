package com.demo.demo_execrise1.exceptions;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.demo.demo_execrise1.dto.CalculatorDTO;
import com.demo.demo_execrise1.dto.ErrorDTO;
import com.demo.demo_execrise1.infra.InvalidInputException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(IllegalArgumentException.class) // catch 
  public ErrorDTO notFoundExceptionHandler(IllegalArgumentException e) {
    return new ErrorDTO(9,"Invalid Input");
  }

  @ExceptionHandler(NumberFormatException.class) // catch 
  public ErrorDTO numberNotFoundExceptionHandler(NumberFormatException e) {
    return new ErrorDTO(10,"NumberFormat");
  }  

  @ExceptionHandler(InvalidInputException.class) // catch 
  public ErrorDTO InvalidInputExceptionHandler(NumberFormatException e) {
    return new ErrorDTO(10,"NumberFormat");
  } 
}
