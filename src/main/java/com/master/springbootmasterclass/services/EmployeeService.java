package com.master.springbootmasterclass.services;

import com.master.springbootmasterclass.constant.AppUtils;
import com.master.springbootmasterclass.entities.Employee;
import com.master.springbootmasterclass.entities.EmployeeDto;
import com.master.springbootmasterclass.exception.EmployeeNotFoundException;
import com.master.springbootmasterclass.exception.ResponseException;
import com.master.springbootmasterclass.repopsitories.EmployeeRepos;
import com.master.springbootmasterclass.response.Request.PaginationArgs;
import com.master.springbootmasterclass.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;



@Service
public class EmployeeService {


    @Autowired
    EmployeeRepos employeeRepos;


    public ResponseEntity<Response> saveEmployee(Employee employee)
    {
       Employee employee1 = employeeRepos.save(employee);
       return Response.getResponseEntity(true,"successfully save",employee1);
    }

   public Page<Employee> getPagenatedEmployee(PaginationArgs paginationArgs)
   {
       Pageable pageable = AppUtils.getPageable(paginationArgs);
       Map<String,Object> specParameters = AppUtils.getParameters(paginationArgs.getParameters());
       String name = (String) specParameters.get("name");
       return employeeRepos.findEmployeeByNameStartingWith(name,pageable);

   }

   public  Employee findEmployee(Long id)
   {
     return   employeeRepos.findById(id).orElseThrow(()->new ResponseException(HttpStatus.NOT_FOUND,"Employee  not Fund",null));
   }


   public boolean deleteEmployee(Long id)
   {
       try {
           employeeRepos.deleteById(id);
           return  true;
       }catch (Exception e)
       {
           return false;
       }




   }


   public List<Employee> getAllEmployyeINSort()
   {
      List<Employee> employees= employeeRepos.findAll();
      Collections.sort(employees,((o1, o2) -> (o1.getName().compareTo(o2.getName()))));
      return  employees;
   }

   public List<Employee> getEmployeergroup(String input)
   {
       List<Employee>employees= employeeRepos.findAll();

     employees.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
     employees.stream().sorted(((o1, o2) -> o1.getName().compareTo(o2.getName()))).forEach(System.out::println);
     employees.stream().sorted((o1, o2) ->o1.getName().compareTo(o2.getName()) ).collect(Collectors.toList());
     employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
     return employees;

   }

   public  void ConvertMapToList(){
//   {
//       Map<String,Integer>mp=new HashMap<>();
//       mp.put("a",1);
//       mp.put("b",2);
//       mp.put("c",3);
////      List<Map.Entry<String,Integer>>entryList=new ArrayList<>(mp.entrySet());
////     Collections.sort(entryList,(o1,o2)-> o1.getValue().compareTo(o2.getValue()) );
////     return entryList;
//       mp.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
//       mp.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
//       return mp;

//









   }



//   public List<Employee>getEmployeesINSort()
//   {
//    List<Employee> employees=  employeeRepos.findAll();
//       Collections.sort(employees,(o1, o2) -> o1.getName().compareTo(o2.getName()));
//       return  employees;
//
//   }

//   class Mycomparator implements Comparator<Employee>
//   {
//
//       @Override
//       public int compare(Employee o1, Employee o2) {
//           return o2.getName().compareTo(o1.getName());
//       }
//   }



EmployeeMapper employeeMapper= new EmployeeMapper();
    public void dispalyemployee()
         {
    List<Employee> employeeList =  employeeRepos.findAll();
    employeeList.stream().forEach(EmployeeService::printEmployee);
    employeeList.stream().forEach(System.out::println  );
    List<String> collectName = employeeList.stream().map(Employee::getName  ).collect(Collectors.toList());


    List<EmployeeDto> employeezDto = employeeList.stream().map(employeeMapper ::convert)
            .collect(Collectors.toList());


   Demo demo= ()-> new Employee();
   demo.getEmployeeData().employeeINfo();

 Demo demo1=  Employee::new;
 demo1.getEmployeeData().employeeINfo();

}

    private static void printEmployee(Employee employee) {

        System.out.println(employee );

    }

    public Employee updateEmployee( Employee employee) throws EmployeeNotFoundException {
         Long id= employee.getId();

         Employee employee1= employeeRepos.findById(id).orElse(null);

         if(Objects.nonNull(employee.getName()) && !"".equalsIgnoreCase(employee.getName()))
         {

             employee1.setName(employee.getName());
         }else {
              throw  new EmployeeNotFoundException("class not foud ...");
         }
         return  employeeRepos.save(employee1);
    }


    public  Employee getEmployee(Long id) throws EmployeeNotFoundException
    {
        return  employeeRepos.findById(id).orElseThrow(()->new EmployeeNotFoundException("not found"));
    }






}
