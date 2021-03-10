package com.employees.demo.dto;

public class EmployeeInsertDTO {
    
    private String name;
    private Integer points;
    private String address;

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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
