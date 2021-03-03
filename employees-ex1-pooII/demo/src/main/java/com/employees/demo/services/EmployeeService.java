package com.employees.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.employees.demo.dto.EmployeeDTO;
import com.employees.demo.entities.Employee;
import com.employees.demo.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDTO> getEmployees(){

        List<Employee> list = repository.getEmployees();
        
        List<EmployeeDTO> listDTO = new ArrayList<>();
        for(Employee e: list){
            listDTO.add(new EmployeeDTO(e.getId(), e.getName(),e.getPoints()));
        }

        return listDTO;
    }
}
