package com.demo.demo_sb_restful.infra;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTPS("https"), //
  HTTP("http"), //
  ;

  private String value;

  private Scheme(String value) {
    this.value = value;
  }

  public String lowercase() {
    return this.value.toLowerCase();
  }

}
