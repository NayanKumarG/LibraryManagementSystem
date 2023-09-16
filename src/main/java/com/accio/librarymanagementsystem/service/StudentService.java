package com.accio.librarymanagementsystem.service;

import com.accio.librarymanagementsystem.dto.requestDto.StudentRequest;
import com.accio.librarymanagementsystem.dto.responseDto.StudentResponse;
import com.accio.librarymanagementsystem.model.Student;

public interface StudentService {

    public StudentResponse addStudent(StudentRequest studentRequest);

    public StudentResponse getStudent(int regno);

    public void deleteStudent(int regno);

    public StudentResponse getStudentByEmail(String email);
}
