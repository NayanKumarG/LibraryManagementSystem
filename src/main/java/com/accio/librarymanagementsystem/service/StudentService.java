package com.accio.librarymanagementsystem.service;

import com.accio.librarymanagementsystem.Enum.CardStatus;
import com.accio.librarymanagementsystem.model.LibraryCard;
import com.accio.librarymanagementsystem.repository.StudentRepository;
import com.accio.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {

        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);

        Student result = studentRepository.save(student);
        return "Student added successfully";


    }

    public Student getStudent(int regno) {

        Optional<Student> optional = studentRepository.findById(regno);
        if(optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }

    public void deleteStudent(int regno) {

        studentRepository.deleteById(regno);
    }
}
