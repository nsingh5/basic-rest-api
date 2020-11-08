package com.narendra.springrestapi.contoller;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModelProperty;

public class Student {
	@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
	private String name;
 
    @ApiModelProperty(notes = "Class of the Student",name="cls",required=true,value="test class")
    private String cls;
 
    @ApiModelProperty(notes = "Country of the Student",name="country",required=true,value="test country")
    @NotNull
    private String country;
    
    public Student(){}
    public Student(String name, String cls, String country) {
        super();
        this.name = name;
        this.cls = cls;
        this.country = country;
    }
 
    public String getName() {
        return name;
    }
 
    public String getCls() {
        return cls;
    }
 
    public String getCountry() {
        return country;
    }
 
    @Override
    public String toString() {
        return "Student [name=" + name + ", cls=" + cls + ", country=" + country + "]";
    }
}
