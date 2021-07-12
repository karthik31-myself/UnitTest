package com.example.UnitTest.service;

import com.example.UnitTest.entity.Students;
import com.example.UnitTest.repository.StudentRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepo studentRepo;

    @Test
    public void getAllUsers() {
        when(studentRepo.findAll()).thenReturn(Stream.of(
                new Students(1, "karthik", "3rd", "II"),
                new Students(2, "Arjun", "2nd", "I")
        ).collect(Collectors.toList()));

        assertEquals(2, studentService.getStudents().size());
    }
    @Test
    public void saveDetailsTest() {
        Students students = new Students(1, "karthik", "3rd", "II");
        when(studentRepo.save(students)).thenReturn(students);
        assertEquals(students, studentService.saveDetails(students));
    }
   /** @Test
    public void findStudentsByRollnoTest() {
        Integer rollno =8;
        when(studentRepo.findStudentsByRollno(rollno)).thenReturn(Stream.of(
                new Students(8,"Arjun","4th","III")
        ).collect(Collectors.toList()));

    }**/

   @Test
    public void deleteStudentTest(){
        Students students = new Students(1, "karthik", "3rd", "II");
        Integer rollno=1;
        studentService.deleteStudentByRollno(rollno);
        verify(studentRepo, times(1)).deleteById(rollno);
    }




}