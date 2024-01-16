package com.master.springbootmasterclass.services;

import com.master.springbootmasterclass.entities.Employee;
import com.master.springbootmasterclass.entities.EmployeeDto;

public class EmployeeMapper {

  public  EmployeeDto convert(Employee employee)
  {
      EmployeeDto employeeDto= new EmployeeDto();
      employeeDto.setId(employee.getId());
      employeeDto.setName(employee.getName());
      employeeDto.setSalary(employee.getSalary());
      employeeDto.setEmail(employee.getEmail());
      employeeDto.setPhoneNumber(employee.getPhoneNumber());
      return employeeDto;
  }





}
