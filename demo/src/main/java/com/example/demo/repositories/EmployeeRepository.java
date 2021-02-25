package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {

    public List<Employee> getEmployees(){
    Employee e1 = new Employee();
    e1.setId(1l);
    e1.setName("Kat");
    e1.setAddress("Rua José Santos, 56");
    e1.setPoints(20);

    Employee e2 = new Employee();
    e2.setId(2l);
    e2.setName("Josh");
    e2.setAddress("Rua Maria Antonieta, 789");
    e2.setPoints(40);

    List<Employee> list = new ArrayList<> ();
    list.add(e1);
    list.add(e2);

    return list;
    }

}
