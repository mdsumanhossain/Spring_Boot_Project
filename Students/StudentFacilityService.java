
package com.CollegeManagement.StudentRestApi.Students;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentFacilityService {
    
     private final StudentDBRepository studentDBRepository;

    @Autowired
    public StudentFacilityService(StudentDBRepository studentDBRepository) {
        this.studentDBRepository = studentDBRepository;
    }
    
    public String Grertings(){
        
        return "Well Come to Oure College Management System ...";
    
    
    }
     public void addNew(StudentFrom studentfrom) {

        // filter student by email
        Optional<StudentFrom> std = studentDBRepository.findByEmail(studentfrom.getEmail());

        // if student exist then return error message
        if (std.isPresent()) {
            throw new IllegalStateException("Email already exist");
        }

        studentDBRepository.save(studentfrom);
    }
  
    
}
