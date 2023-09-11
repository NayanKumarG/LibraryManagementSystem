package com.accio.librarymanagementsystem.controller;

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
    public ResponseEntity addStudent(@RequestBody Student student)
    {
//        Student studentResponse = studentService.addStudent(student);
        String studentResponse = studentService.addStudent(student);
            return new ResponseEntity(studentResponse , HttpStatus.CREATED);

//        return new ResponseEntity<>("Student already added" , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getStudent")
    public ResponseEntity getStudent(@RequestParam("id") int regno)
    {
        Student student = studentService.getStudent(regno);
        if(student!=null)
        {
            return new ResponseEntity(student , HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid id!!" , HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int regno)
    {
        studentService.deleteStudent(regno);
        return new ResponseEntity("Student deleted from databse:" , HttpStatus.FOUND);
    }
}
