package com.employees.demo.dto;

public class EmployeeDTO {
    
    private Long id;
    private String name;
    private Integer points;

    public EmployeeDTO() {
	}
    public EmployeeDTO(Long id, String name, Integer points) {
	    setId(id);
        setName(name);
        setPoints(points);
    }
	
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

    public Integer getPoints(){
        return points;
    }
    public void setPoints(Integer points){
        this.points = points;
    }
}
