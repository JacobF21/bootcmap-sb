package com.demo.demo_execrise1.dto;

import com.demo.demo_execrise1.model.Operation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalculatorDTO {
  private String x;
  private String y;
  private String opt;
  private String result;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }
}


