
package com.CollegeManagement.StudentRestApi.Students;

import java.util.ArrayList;
import java.util.List;



public class StudentUtilsService {
    
    public static ResponseStudent singleIdFind(StudentFrom studentfrom){
        
        return new ResponseStudent(
                studentfrom.getId(),
                studentfrom.getName(),
                studentfrom.getDepertment(),
                studentfrom.getBirth_date(),
                studentfrom.getAdmit_year(),
                studentfrom.getAddress()
        
        );
    
    }
    
    public static List<ResponseStudent> MultiObeToJeson(List<StudentFrom> studentlist){
        
        List<ResponseStudent> returnStudentList = new ArrayList<>();
        
        for(StudentFrom studentfrom : studentlist){
            
            ResponseStudent studentdata = new ResponseStudent(
                    studentfrom.getId(),
                    studentfrom.getName(),
                    studentfrom.getDepertment(),
                    studentfrom.getBirth_date(),
                    studentfrom.getAdmit_year(),
                    studentfrom.getAddress()     
            
            );
            returnStudentList.add(studentdata);
        
        }
        return returnStudentList;
    
    
    
    }
    
}
