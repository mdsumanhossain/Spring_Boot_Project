
package com.CollegeManagement.StudentRestApi.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/students")
public class StudentServiceController {
    
    private final StudentFacilityService studentFacilityService;
      
    @Autowired
    public StudentServiceController(StudentFacilityService studentFacilityService){
        this.studentFacilityService = studentFacilityService;
    
    }
    
    @GetMapping(path = "/mainmenu")
    public ResponseEntity<String> homepage(){
        
        return new ResponseEntity<>(
                studentFacilityService.Grertings(),
                HttpStatus.OK
        
        ) ;
    
    }
    
}
