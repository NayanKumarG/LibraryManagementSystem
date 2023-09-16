package com.accio.librarymanagementsystem.controller;

import com.accio.librarymanagementsystem.dto.requestDto.StudentRequest;
import com.accio.librarymanagementsystem.dto.responseDto.StudentResponse;
import com.accio.librarymanagementsystem.service.StudentService;
import com.accio.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest)
    {
        StudentResponse studentResponse = studentService.addStudent(studentRequest);
        return new ResponseEntity(studentResponse , HttpStatus.CREATED);
    }

    @GetMapping("/getByEmail")
    public ResponseEntity getStudentByEmail(@RequestParam("email")String email)
    {
        try {
            StudentResponse studentResponse = studentService.getStudentByEmail(email);
            return new ResponseEntity<>(studentResponse, HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getStudent")
    public ResponseEntity getStudent(@RequestParam("id") int regno)
    {
        try
        {
        StudentResponse studentResponse = studentService.getStudent(regno);
        return new ResponseEntity(studentResponse , HttpStatus.FOUND);
        }
        catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int regno)
    {
        studentService.deleteStudent(regno);
        return new ResponseEntity("Student deleted from databse:" , HttpStatus.FOUND);
    }
}
