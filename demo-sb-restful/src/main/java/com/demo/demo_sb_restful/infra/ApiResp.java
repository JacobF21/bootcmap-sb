package com.demo.demo_sb_restful.infra;

import java.util.Arrays;
import java.util.List;
import com.demo.demo_sb_restful.dto.UserDTO;
import lombok.ToString;

@ToString
public class ApiResp<T> {
  private int id;
  private String message;
  private List<T> data;

  public int getId(){
    return this.id;
  }

  public String getMessage(){
    return this.message;
  }

  public List<T> getData(){
    return this.data;
  }

  public static class ApiRespBuilder<T>{
        private int id;
        private String message;
        private List<T> data;

        public ApiRespBuilder<T> withId(int id) {
            this.id = id;
            return this;
        }

        public ApiRespBuilder<T> withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiRespBuilder<T> withData(List<T> data) {
            this.data = data;
            return this;
        }

        public ApiResp build(){
          ApiResp<T> apiResp = new ApiResp<>();
          apiResp.id = this.id;
          apiResp.message = this.message;
          apiResp.data = this.data;
          return apiResp;
        }

  }

  public static void main(String[] args) {
    //Java 9
    List.of("abc","def");

    //Java 8
    Arrays.asList("abc","de");
    Arrays.asList(new String[]{"abc","def"});

    ApiResp<UserDTO> test=new ApiRespBuilder().withData(Arrays.asList("abc","de")).withId(SysCode.OK.getCode()).withMessage("gg").build();
    System.out.println(test);
  }
}
