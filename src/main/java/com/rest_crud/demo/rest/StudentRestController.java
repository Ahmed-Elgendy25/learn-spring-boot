package com.rest_crud.demo.rest;

import com.rest_crud.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List <Student> theStudents;
    // define @PostConstruct to load the student data
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Ahmed","Ashraf"));
        theStudents.add(new Student("Ahmed","Hany"));
        theStudents.add(new Student("Ahmed","Bahaa"));
        theStudents.add(new Student("Ahmed","Esmat"));

    }
    // define endpoints for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //check the student id against list size

        if(studentId>=theStudents.size()||studentId<0) {
            throw new StudentNotFoundException("Student not found - " + studentId);
        }

        return theStudents.get(studentId);

    }



    
}
