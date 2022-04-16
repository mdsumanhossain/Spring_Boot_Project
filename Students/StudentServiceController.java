
package com.CollegeManagement.StudentRestApi.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//RestController kaj sob file ke main file sate control kora
@RequestMapping(path = "api/v1/students")//requsetmapping kaj holo sob request dora

public class StudentServiceController {
    
    private final StudentFacilityService studentFacilityService;
      
    @Autowired
    public StudentServiceController(StudentFacilityService studentFacilityService){
        this.studentFacilityService = studentFacilityService;
    
    }
    //home page And get method kaj kore
    @GetMapping(path = "/mainmenu")
    public ResponseEntity<String> homepage(){
        
        return new ResponseEntity<>(
                studentFacilityService.Grertings(),
                HttpStatus.OK
        
        ) ;
    
    }
    //create and post method kaj korbe 
    @PostMapping(path = "/create")
    public ResponseEntity<String> registerNewStudent(@RequestBody StudentFrom studentform) {

        studentFacilityService.addNew(studentform);//studentfacilityservice teke addnew method teke email k kojar jonno 

        return new ResponseEntity<>(                // return hisebe responseentity body te successful dekabe
                "Successfully created",
                HttpStatus.CREATED
        );
    }
    @DeleteMapping(path ="/Delete/id")
    public ResponseEntity<String> studentIdDelet(@PathVariable("StudentId") Long studentid)
    {
        studentFacilityService.deleteId(studentid);
        return new ResponseEntity<>(              
                "Successfully Deletes",
                HttpStatus.OK

        );
    
    }
    
}
