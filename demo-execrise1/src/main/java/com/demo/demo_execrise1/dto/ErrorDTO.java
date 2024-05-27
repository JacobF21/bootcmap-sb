package com.demo.demo_execrise1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDTO {
  int code;
  String error;
}
