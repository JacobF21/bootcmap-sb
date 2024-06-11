package com.demo.demo_forum.model.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiRes<T> {
  private String code;
  private String message;
  private List<T> data;
}
