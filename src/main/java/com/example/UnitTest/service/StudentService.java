package com.example.UnitTest.service;

import com.example.UnitTest.entity.Students;
import com.example.UnitTest.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Students saveDetails(Students students) {
        return studentRepo.save(students);
    }

    public  Students findStudentByRollno(Integer rollno) {
        return studentRepo.findStudentsByRollno(rollno);
    }

    public Students updateStudentDetails(Students students) {
        Students existStu=studentRepo.findStudentsByRollno(students.getRollno());
        existStu.setName(students.getName());
        existStu.setStd(students.getStd());
        existStu.setSec(students.getSec());

        return studentRepo.save(existStu);
    }

    public String deleteStudentByRollno(Integer rollno) {
        studentRepo.deleteById(rollno);
        return "";
    }

    public List<Students> getStudents() {
        return studentRepo.findAll();
    }
}
