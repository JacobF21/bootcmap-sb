package com.bootcamp.demo.democalculator.controller.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.democalculator.model.Address;
import com.bootcamp.demo.democalculator.model.Customer;
import com.bootcamp.demo.democalculator.model.Order;
import com.bootcamp.demo.democalculator.controller.CustomerOperation;

@Controller
@ResponseBody
public class CustomerController implements CustomerOperation{
  

  @Override
  public List<Customer> getAll(){
    Address a1 = new Address("abc", "def", "ijk");
    Address a2 = new Address("bbb", "def", "ijk");
    Address a3 = new Address("aaa", "def", "ijk");

    Order o1=new Order(1,a1);
    Order o2=new Order(2,a2);
    Order o3=new Order(3,a3);

    List<Order> orderList1=new ArrayList<>();
    orderList1.add(o1);
    List<Order> orderList2=new ArrayList<>();
    orderList2.add(o2);
    orderList2.add(o3);

    List<Customer> customers = new LinkedList<>();
    customers.add(new Customer("Vincent", LocalDate.of(2013,10,1), orderList1));
    customers.add(new Customer("Jenny", LocalDate.of(2011,11,1), orderList2));

    return customers;
  }

}
