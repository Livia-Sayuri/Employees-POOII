package com.employees.demo.dto;

public class EmployeeUpdateDTO {
    
    private String name;
    private Integer points;

    public String getName (){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Integer getPoints(){
        return points;
    }
    public void setPoints(Integer points){
        this.points = points;
    }
}
