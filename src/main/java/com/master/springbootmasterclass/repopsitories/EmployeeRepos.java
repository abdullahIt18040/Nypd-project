package com.master.springbootmasterclass.repopsitories;

import com.master.springbootmasterclass.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepos extends JpaRepository<Employee,Long> {
    @Override
    Page<Employee> findAll(Pageable pageable);

     public Employee findByNameIgnoreCase(String name);

     Page<Employee>findEmployeeByNameStartingWith(String name,Pageable pageable);
  //  Page<Instructor> findInstructorByPostcodeStartsWith(String postcodePrefix, Pageable pageable);
}
