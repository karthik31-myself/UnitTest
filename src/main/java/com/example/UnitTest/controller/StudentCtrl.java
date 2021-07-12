package com.example.UnitTest.controller;

import com.example.UnitTest.entity.Students;
import com.example.UnitTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentCtrl {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public Students saveDetails(@RequestBody Students students){
        return studentService.saveDetails(students);
    }

    @GetMapping("/{id}")
    public Students findStudentByRollno(@PathVariable("id") Integer rollno){
        return studentService.findStudentByRollno(rollno);
    }

    @GetMapping("/getAll")
    public List<Students> getStudents(){
        return studentService.getStudents();

    }

    @PutMapping("/update")
    public Students updateStudentDetails(@RequestBody Students students){
        return studentService.updateStudentDetails(students);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentByRollno(@PathVariable("id") Integer rollno){
         studentService.deleteStudentByRollno(rollno);
        return "deleted!";
    }
}
