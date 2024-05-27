package com.bootcamp.demo.democalculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.democalculator.model.Student;

public interface StudentOperation {

  @GetMapping(value = "/students")
  List<Student> getAll();
}
