package com.employees.demo.entities;

public class Employee {
    
    private Long id;
    private String name;
    private String address;
    private Integer points;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName (){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public Integer getPoints(){
        return points;
    }
    public void setPoints(Integer points){
        this.points = points;
    }
}