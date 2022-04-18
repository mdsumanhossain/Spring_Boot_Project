
package com.CollegeManagement.StudentRestApi.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    //HOME PAGE CONTROLL
    //home page And get method kaj kore
    @GetMapping(path = "/mainmenu")
    public ResponseEntity<String> homepage(){
        
        return new ResponseEntity<>(
                studentFacilityService.Grertings(),
                HttpStatus.OK
        
        ) ;
    
    }
    //CREATE METHOD PARAMETAR PAS
    //create and post method kaj korbe 
    @PostMapping(path = "/create")
    public ResponseEntity<String> registerNewStudent(@RequestBody StudentFrom studentform) {

        studentFacilityService.addNew(studentform);//studentfacilityservice teke addnew method teke email k kojar jonno 

        return new ResponseEntity<>(                // return hisebe responseentity body te successful dekabe
                "Successfully created",
                HttpStatus.CREATED
        );
    }
    //UPDATE METHOD PERAMETAR PASS 
    @PutMapping(path = "{studentId}")
    public ResponseEntity<String> studentIdUpdate(  // akane amra id and body k call korci jemon 
            @PathVariable("studentId")Long studentId,//PathVariable studentId Id and ->
            @RequestBody StudentFrom studentfrom //->RequestBody StudentFrom er Object k
    ){
        studentFacilityService.UpdateStudentId(studentId, studentfrom);//and StudentFacilityService UpdateStudentID
        return new ResponseEntity<>(                                   //vitor studentId And studentfrom data raka hobe
                "Succesfully Updated",
                HttpStatus.ACCEPTED
        );
    
    }
    //DELETE METHOD PERAMETAR PASS
    @DeleteMapping(path ="/Delete/{StudentId}")
    public ResponseEntity<String> studentIdDelet(@PathVariable("StudentId") Long studentid)
    {
        studentFacilityService.deleteId(studentid);
        return new ResponseEntity<>(              
                "Successfully Deletes",
                HttpStatus.OK

        );
    
    }
    
}
