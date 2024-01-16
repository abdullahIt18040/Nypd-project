package com.master.springbootmasterclass.controllers;

import com.master.springbootmasterclass.constant.AscOrDescType;
import com.master.springbootmasterclass.entities.Employee;
import com.master.springbootmasterclass.response.Request.PaginationArgs;
import com.master.springbootmasterclass.response.Response;
import com.master.springbootmasterclass.services.Demo;
import com.master.springbootmasterclass.services.EmployeeService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.master.springbootmasterclass.constant.AppConstant.*;

@RestController
    public class HomeControllor {
    @Value("${welcome.message}")
    private  String msg;

    public  void display()
    {
        System.out.println(" this is my classs ......");
    }

    @Autowired
   private EmployeeService employeeService;
//     @Autowired
//     Demo demo;
//   Demo demos =  ()->{
//        System.out.println("this is finctioal interface ");
//    };































    @GetMapping("/home")
    public String home(@RequestParam String name)
    {
        System.out.println("this is my home paye ");
        return "this is my welcome come page";
    }
    @PostMapping("/saveemployee")
    public ResponseEntity<Response> saveEmploy(@RequestBody Employee employee)
    {
      return employeeService.saveEmployee(employee);

    }

    @GetMapping(value = "/paginated")
    public ResponseEntity<Response> getPaginatedInstructors(
            @RequestParam(value = PAGE_NO, defaultValue = "0") int pageNo,
            @RequestParam(value = PAGE_SIZE, defaultValue = "10") int pageSize,
            @RequestParam(name = SORT_BY, defaultValue = SORT_BY_VALUE) String sortBy,
            @RequestParam(name = ASC_OR_DESC, defaultValue = ASC_OR_DESC_VALUE) AscOrDescType ascOrDesc,
            @RequestParam(value = "name") String name
    ) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", name);
        PaginationArgs paginationArgs = new PaginationArgs(
                pageNo, pageSize, sortBy, ascOrDesc, parameters
        );

        return Response.getResponseEntity(
                true,
                "Fetched instructors successfully",
                employeeService.getPagenatedEmployee(paginationArgs));
    }

    @GetMapping("/findemployee/{id}")
    public ResponseEntity<Response>findEmployee(@PathVariable Long id)
    {
        return Response.getResponseEntity(true,"successfull",employeeService.findEmployee(id));
    }

@DeleteMapping("/delete/{id}")
    public ResponseEntity<Response>deleteEmployee(@PathVariable Long id)
    {
        Boolean isDelete= employeeService.deleteEmployee(id);
        if(isDelete)
        {
            return Response.getResponseEntity(true,"delete successfully",null);
        }else {

            return Response.getResponseEntity(false,"not delete",null);
        }

    }
    @GetMapping("/all")
    public List<Employee>getAllEmployeeinsort()
    {
        return  employeeService.getAllEmployyeINSort();
    }


}
