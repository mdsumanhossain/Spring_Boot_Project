
package com.CollegeManagement.StudentRestApi.Students;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentFacilityService {
    
     private final StudentDBRepository studentDBRepository;
     
     //create file jonno ai object k create kora holo
     //
    @Autowired
    public StudentFacilityService(StudentDBRepository studentDBRepository) {//ai khane create method er jonno
        this.studentDBRepository = studentDBRepository;         //studentdbrepository object create kora hoice
    }
    //HOME PAGE GETRTINGS METHOD USE
    //home page ai kan teke call korce
    public String Grertings(){
        
        return "Well Come to Oure College Management System ...";
    
    
    }
    //READ ALL STUDENT SERVICE EXIST 
    public List<StudentFrom> getAllToStudentsInfo(){
        
        return studentDBRepository.findAll();
    
    }
    //READ STUDENT ONE BY ONE ID
    public StudentFrom getStudentOneId (long studentId){
        
        StudentFrom studentfrom = studentDBRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException(
                        "Student With id"+studentId+"dose not exist"
                
                ));
        return studentfrom;
    
    }
    
    //CREATE METHOD USE
    //create studentDBRepositoty teke student from data k call kora holo
     public void addNew(StudentFrom studentfrom) {

        // filter student by email
        Optional<StudentFrom> std = studentDBRepository.findByEmail(studentfrom.getEmail());

        // if student exist then return error message
        if (std.isPresent()) {
            throw new IllegalStateException("Email already exist");
        }

        studentDBRepository.save(studentfrom);
    }
     //UPADATE METHOD USE
     @Transactional
     public void UpdateStudentId(
             Long studentId,
             StudentFrom updateStudentId
     ){
         
         StudentFrom currentStudentId = studentDBRepository.findById(studentId)
                 .orElseThrow(()-> new IllegalStateException(
                         "StudentFrom with id"+studentId+"dose not exist")
                 );
         
         //Name
         if(updateStudentId.getName()!=null){
             currentStudentId.setName(updateStudentId.getName());
         }
         //Department
         if(updateStudentId.getDepertment()!=null){
             currentStudentId.setDepertment(updateStudentId.getDepertment());
         }
         //Birth_Date
         if(updateStudentId.getBirth_date() !=null){
             currentStudentId.setBirth_date(updateStudentId.getBirth_date());
         }
         //Admit_Year
         if(updateStudentId.getAdmit_year() != null){
             currentStudentId.setAdmit_year(updateStudentId.getAdmit_year());
         }
         //Address
         if(updateStudentId.getAddress() != null){
            currentStudentId.setaAddress(updateStudentId.getAddress());
         }
     }
     //DELETE METHOD USE
     public void deleteId(Long id){
         
         boolean isExist = studentDBRepository.existsById(id);
         
         if(!isExist){
             throw new IllegalStateException("Student Not Found With This "+id);
         }
         studentDBRepository.deleteById(id);
     
     
     } 
  
    
}
