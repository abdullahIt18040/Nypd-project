package com.master.springbootmasterclass;

import com.master.springbootmasterclass.services.BiFunctionalnterface;
import com.master.springbootmasterclass.services.Demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringbootMasterclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMasterclassApplication.class, args);


           BiFunction biFunction = new BiFunctionalnterface();
           List<Integer>list1= Stream.of(1,2,3,4,5).collect(Collectors.toList());
           List<Integer>list2 = Stream.of(4,8,9,9).collect(Collectors.toList());
           System.out.println(biFunction.apply(list1,list2));








       // nums.stream().filter(t-> t%2==0).forEach(t-> System.out.println(" this is even num "+ t));







//
//        Demo demo= ()-> {
//            System.out.println(" this is my functial interface ");
//        };
//
//        demo.display();
//
//         Demo demo = (a,b)->{
//             if(a<b)
//             {
//                 throw  new RuntimeException(" a is less than b");
//             }else {
//                 return  a+b;
//             }
//         };
//
//        System.out.println(demo.sum(12,8));

    }

}
