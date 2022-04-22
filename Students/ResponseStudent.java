
package com.CollegeManagement.StudentRestApi.Students;

import java.time.LocalDate;
import java.time.Period;


public class ResponseStudent {
    
    private Long id;
    private String name;
    private String depertment;
    private LocalDate birth_date;
    private int age;
    private String admit_year;
    private String address;
    
    public ResponseStudent(
            long id,
            String name,
            String depertment,
            LocalDate birth_date,
            String admit_year,
            String address)
    {
        this.id = id;
        this.name = name;
        this.depertment = depertment;
        this.birth_date = birth_date;
        this.age = getAge();
        this.admit_year = admit_year;
        this.address = address;
    }
    
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDepertment(){
        return this.depertment;
    }
    public void setDepertment(String depertment){
        this.depertment = depertment;
    }
    public int getAge(){
        return Period.between(this.birth_date, LocalDate.now()).getYears();
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getAdmit_year(){
        return this.admit_year;
    }
    public void setAdmit_year(String admit_year){
        this.admit_year = admit_year;
    }
    public String getAddres(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    
}
