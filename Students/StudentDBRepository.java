
package com.CollegeManagement.StudentRestApi.Students;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentDBRepository extends JpaRepository<StudentFrom, Long> {

    // select * from student where email = <givenEmail>;
    Optional<StudentFrom> findByEmail(String email);
}
