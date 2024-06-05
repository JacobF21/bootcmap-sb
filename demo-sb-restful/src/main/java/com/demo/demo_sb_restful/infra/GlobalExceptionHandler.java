package com.demo.demo_sb_restful.infra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.demo.demo_sb_restful.infra.ApiResp.ApiRespBuilder;
import lombok.Getter;

// @RestControllerAdvice // @ContollerAdvice + @ResponseBody
public class GlobalExceptionHandler {

  @ExceptionHandler(NumberFormatException.class) // catch
  public ErrorResponse numberFormatExceptionHandler(NumberFormatException e) {
    return ErrorResponse.of(ErrorCode.NFE.getCode(), ErrorCode.NFE.getDesc());
  }

  @ExceptionHandler(NullPointerException.class)
  public ErrorResponse nullPointerExceptionHandler(NullPointerException e) {
    return ErrorResponse.of(ErrorCode.NPE.getCode(), ErrorCode.NPE.getDesc());
  }

  @ExceptionHandler(ArithmeticException.class)
  public ErrorResponse arithmeticExceptionHandler(ArithmeticException e) {
    return ErrorResponse.of(ErrorCode.AE.getCode(), ErrorCode.AE.getDesc());
  }

  @ExceptionHandler(BusinessRuntimeException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp businessRuntimeExceptionHandler(
      BusinessRuntimeException e) {
    return new ApiRespBuilder().withId(e.getCode()).withMessage(e.getMessage()).withData(new ArrayList<>(Arrays.asList(5, 6))).build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value=HttpStatus.BAD_REQUEST)
  public ErrorResponse unhandledException(){
     return new ErrorResponse(9999, "Other unhandled exception");
  }

  @Getter
  private enum ErrorCode {
    NPE(99, "Null Pointer Exception."), //
    NFE(99, "Number Format Exception."), //
    AE(99, "Arithmetic Exception."), //
    ;

    private int code;
    private String desc;

    private ErrorCode(int code, String desc) {
      this.code = code;
      this.desc = desc;
    }
  }

  // Alternative
  // @ExceptionHandler({NumberFormatException.class, NullPointerException.class,
  // ArithmeticException.class})
  // public ErrorResponse exceptionHandler(RuntimeException e) {
  // if (e instanceof NumberFormatException) {
  // return ErrorResponse.of(ErrorCode.NFE.getCode(), ErrorCode.NFE.getDesc());
  // } else if (e instanceof NullPointerException) {
  // return ErrorResponse.of(ErrorCode.NPE.getCode(), ErrorCode.NPE.getDesc());
  // } else if (e instanceof ArithmeticException) {
  // return ErrorResponse.of(ErrorCode.AE.getCode(), ErrorCode.AE.getDesc());
  // }
  // return ErrorResponse.of(99999, "Unhandled Exception.");
  // }

}
