package com.accio.librarymanagementsystem.transformer;

import com.accio.librarymanagementsystem.dto.requestDto.StudentRequest;
import com.accio.librarymanagementsystem.dto.responseDto.StudentResponse;
import com.accio.librarymanagementsystem.model.Student;

public class StudentTransformer {

    //mapping studentrequest--student
    public static Student StudentRequestToStudent(StudentRequest studentRequest)
    {
        return Student.builder()
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .name(studentRequest.getName())
                .gender(studentRequest.getGender())
                .build();
    }

    //mapping student---studentresponse
    public static StudentResponse StudentToStudentResponse(Student student)
    {
        return StudentResponse.builder()
                .email(student.getEmail())
                .name(student.getName())
                .gender(student.getGender())
                .libraryCardResponse(LibraryCardTransformer.StudentToLibraryCardResponse(student))
                .build();
    }
}
