package com.master.springbootmasterclass.entities;

import com.master.springbootmasterclass.model.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "employees")
public class Employee extends AuditModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = " please give me name ")
    private String name;
    private String email;

    private String phoneNumber;
    private String password;
    private Double salary;

    public void employeeINfo()
    {
        System.out.println(" this is employee info ....");
    }
}
