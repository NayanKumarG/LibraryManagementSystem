package com.accio.librarymanagementsystem.service.impl;

import com.accio.librarymanagementsystem.Enum.CardStatus;
import com.accio.librarymanagementsystem.dto.requestDto.StudentRequest;
import com.accio.librarymanagementsystem.dto.responseDto.LibraryCardResponse;
import com.accio.librarymanagementsystem.dto.responseDto.StudentResponse;
import com.accio.librarymanagementsystem.exception.StudentNotFoundException;
import com.accio.librarymanagementsystem.model.LibraryCard;
import com.accio.librarymanagementsystem.repository.StudentRepository;
import com.accio.librarymanagementsystem.model.Student;
import com.accio.librarymanagementsystem.service.StudentService;
import com.accio.librarymanagementsystem.transformer.LibraryCardTransformer;
import com.accio.librarymanagementsystem.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    public StudentResponse addStudent(StudentRequest studentRequest) {
        //map dto with model for required fields
        Student student = StudentTransformer.StudentRequestToStudent(studentRequest);

//        Student student = new Student();
//        student.setName(studentRequest.getName());
//        student.setAge(studentRequest.getAge());
//        student.setEmail(studentRequest.getEmail());
//        student.setGender(studentRequest.getGender());

        //set library card for new student
        LibraryCard libraryCard = LibraryCardTransformer.prepareLibraryCard();
//        LibraryCard libraryCard = new LibraryCard();
//        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
//        libraryCard.setCardStatus(CardStatus.ACTIVE);

        libraryCard.setStudent(student); // set student in librarycard

        student.setLibraryCard(libraryCard);//set library card

        //save in db (will return actual object with all fields
        Student savedStudent = studentRepository.save(student);

        return StudentTransformer.StudentToStudentResponse(savedStudent);

//        map model to dto to tranfer to the client which is only required fields
//        StudentResponse studentResponse = new StudentResponse();
//        studentResponse.setName(savedStudent.getName());
//        studentResponse.setEmail(savedStudent.getEmail());
//        studentResponse.setGender(savedStudent.getGender());
//
//        //map librarycardresponse dto from model
//        LibraryCardResponse libraryCardResponse = new LibraryCardResponse();
//        libraryCardResponse.setCardno(savedStudent.getLibraryCard().getCardNo());
//        libraryCardResponse.setCardStatus(savedStudent.getLibraryCard().getCardStatus());
//        libraryCardResponse.setIssuedDate(savedStudent.getLibraryCard().getIssueDate());
//
//        //set cardresponse in studentresponse(nested dto)
//        studentResponse.setLibraryCardResponse(libraryCardResponse);

//        return studentResponse;


    }

    public StudentResponse getStudent(int regno) {

        Optional<Student> optional = studentRepository.findById(regno);
        if(optional.isEmpty())
        {
            throw  new StudentNotFoundException("Invalid id!!!");
        }
        return StudentTransformer.StudentToStudentResponse(optional.get());
    }

    public void deleteStudent(int regno) {

        studentRepository.deleteById(regno);
    }

    public StudentResponse getStudentByEmail(String email) {

        //get optional studentif found using jpa method defined by developer.(implementation given by hibernate)
        Optional<Student> studentOptional = studentRepository.findByEmail(email);
        if(studentOptional.isEmpty()) throw new StudentNotFoundException("Student not found for given emailid!!");

        //map studentresponse dto from model
        Student student = studentOptional.get();
        StudentResponse studentResponse = StudentTransformer.StudentToStudentResponse(student);
        return studentResponse;
    }
}
