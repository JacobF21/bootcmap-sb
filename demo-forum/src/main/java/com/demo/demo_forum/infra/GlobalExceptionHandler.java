package com.demo.demo_forum.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

public class GlobalExceptionHandler {
  
  @ExceptionHandler(InvalidInputException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse invalidInputExceptionHandler(InvalidInputException e){
      return ErrorResponse.of(ErrorCode.INVALID_INPUT.getCode(),ErrorCode.INVALID_INPUT.getDesc());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(NotFoundException e){
      return ErrorResponse.of(ErrorCode.NOT_FOUND.getCode(),ErrorCode.NOT_FOUND.getDesc());
  }

  @ExceptionHandler(RestTemplateErrorException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse restTemplateExceptionHandler(InvalidInputException e){
      return ErrorResponse.of(ErrorCode.REST_TEMPLATE.getCode(),ErrorCode.REST_TEMPLATE.getDesc());
  }

  @ExceptionHandler(HttpClientErrorException.class)
  public ErrorResponse handleHttpClientErrorException(HttpClientErrorException ex) {
      return ErrorResponse.of(ErrorCode.REST_TEMPLATE.getCode(),ErrorCode.REST_TEMPLATE.getDesc());
  }
}
