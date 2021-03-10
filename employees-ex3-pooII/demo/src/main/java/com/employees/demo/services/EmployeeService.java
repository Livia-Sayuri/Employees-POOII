package com.employees.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.employees.demo.dto.EmployeeDTO;
import com.employees.demo.dto.EmployeeInsertDTO;
import com.employees.demo.dto.EmployeeUpdateDTO;
import com.employees.demo.entities.Employee;
import com.employees.demo.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDTO> getEmployees(){

        List<Employee> list = repository.findAll();
        return toDTOList(list);
    } 

    public EmployeeDTO getEmployeeById(Long id){
        
        Optional <Employee> op = repository.findById(id);
        Employee employee = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found!"));
        
        return new EmployeeDTO(employee);
    }

    public EmployeeDTO insert(EmployeeInsertDTO insertDTO){

        Employee entity = new Employee(insertDTO);
        entity = repository.save(entity);
        return new EmployeeDTO(entity);
    }

    public void delete(Long id){
        try{
             repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found!");
        }
    }

    public EmployeeDTO update(Long id, EmployeeUpdateDTO updateDTO){
        try{
        Employee entity = repository.getOne(id);
        entity.setName(updateDTO.getName());
        entity.setPoints(updateDTO.getPoints());
        entity = repository.save(entity);
        return new EmployeeDTO(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found!");
        }
    }


    private List<EmployeeDTO> toDTOList(List<Employee> list){
        
        List<EmployeeDTO> listDTO = new ArrayList<>();
        
        for(Employee e: list){
            listDTO.add(new EmployeeDTO(e.getId(), e.getName(),e.getPoints()));
        }
        return listDTO;
    
    }
}

