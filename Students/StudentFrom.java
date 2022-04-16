
package com.CollegeManagement.StudentRestApi.Students;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
public class StudentFrom implements Serializable {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "student_id")
    private long id;
    
    private String name;
    private String depertment;
    private LocalDate birth_date;
    
    @Transient
    private int age;
    
    private int admit_year;
    private String email;
    private String address;
    
    
    public StudentFrom(){
    
    }
    
    public StudentFrom(
                    long id,
                    String name,
                    String depertment,
                    LocalDate birth_date,
                    int age,
                    int admit_year, 
                    String email,
                    String address
                    ){
                    
                    this.id = id;
                    this.name = name;
                    this.depertment = depertment;
                    this.age = age;
                    this.birth_date = birth_date;
                    this.admit_year = admit_year;
                    this.email = email;
                    this.address = address;
    
    }
    public long getId(){
        return this.id;
    }
    
    public void setId(long id){
            this.id = id;
    }
    
    public String getName(){
            return name;
    }
    
    public void setName(String name){
        this.name = name;
    
    }
    public String getDepertment(){
            return depertment;
    }
    
    public void setDepertment(String depertment){
        this.depertment = depertment;
    
    }
    public int getAge(){
            return this.age;
    }
    
    public void setAge(int age){
        this.age = age;
    
    }
    public int getBirth_date(){
            return Period.between(this.birth_date, LocalDate.now()).getYears();
    }
    
    public void setBirth_date(LocalDate birth_date){
        this.birth_date = birth_date;
    
    }
    public int getAdmit_year(){
            return admit_year;
    }
    
    public void setAdmit_year(int admit_year){
        this.admit_year = admit_year;
    
    }
    public String getEmail(){
            return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    
    }
    public String getAddress(){
            return address;
    }
    
    public void setaAddress(String address){
        this.address = address;
    
    }
    
}
