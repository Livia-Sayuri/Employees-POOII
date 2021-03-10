package com.employees.demo.controllers;

import java.net.URI;
import java.util.List;

import com.employees.demo.dto.EmployeeDTO;
import com.employees.demo.dto.EmployeeInsertDTO;
import com.employees.demo.dto.EmployeeUpdateDTO;
import com.employees.demo.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
    
        List <EmployeeDTO> list = service.getEmployees();
        return ResponseEntity.ok().body(list);
    }

    
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
    
        EmployeeDTO dto = service.getEmployeeById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeInsertDTO insertDto){
        EmployeeDTO dto = service.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeUpdateDTO updateDto, @PathVariable Long id){
        EmployeeDTO dto = service.update(id, updateDto);
        return ResponseEntity.ok().body(dto);
    }


}
