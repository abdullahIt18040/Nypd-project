package com.master.springbootmasterclass.services;

import com.master.springbootmasterclass.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@FunctionalInterface
public interface Demo  {
   public Employee getEmployeeData();
}
