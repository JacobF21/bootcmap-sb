package com.bootcamp.demo.democalculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.democalculator.controller.DatabaseOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.Integer;
import java.security.Timestamp;
import java.util.Arrays;
import java.util.Collection;


@Controller
@ResponseBody
public class DatabaseController implements DatabaseOperation{

  private static int[] arr=new int[]{10,-3,9};

  @Override
  //Design an API, get the value from array by index
  public String demoApi(int x){
    try{
    } catch (IndexOutOfBoundsException e){
      return "x should be between 0 and " + arr.length;
    } catch( NumberFormatException e2){
      return "the index should be an integer";
    }
    return Integer.toString(arr[x]);
  }

  @Override
  public int[] sort(){
    return Arrays.stream(arr).sorted().toArray();

  }

  @Override
  public int[] descSort(){
    int[] newArr= Arrays.stream(arr).boxed()
                        .sorted((i1,i2)-> i1.compareTo(i2) > 0 ? -1:1)
                        .mapToInt(e->e.intValue())
                        .toArray();
    for(int i=0;i<arr.length;i++){
      arr[i] = newArr[i]; 
    }
    return newArr;
  }
}
