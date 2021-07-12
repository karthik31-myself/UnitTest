package com.example.UnitTest.repository;

import com.example.UnitTest.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Students,Integer> {
    Students findStudentsByRollno(Integer rollno);


}
