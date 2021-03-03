package com.employees.demo.controllers;

import java.util.List;

import com.employees.demo.dto.EmployeeDTO;
import com.employees.demo.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployee(){
    
        List <EmployeeDTO> list = service.getEmployees();
        return ResponseEntity.ok().body(list);
    }
}
