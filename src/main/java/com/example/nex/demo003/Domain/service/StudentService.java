package com.example.nex.demo003.Domain.service;

import com.example.nex.demo003.Application.dto.request.CreateStudentDto;
import com.example.nex.demo003.Application.dto.response.StudentGeneralDto;
import com.example.nex.demo003.Domain.entity.Student;
import com.example.nex.demo003.External.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    final private StudentRepo studentRepo;

    public ResponseEntity<StudentGeneralDto> getStudent(String id) {
        logger.info("Looking for student with ID: {}", id);
        Optional<Student> optionalStudent = studentRepo.findById(id);

        if (optionalStudent.isPresent()) {
            Student newStudent = optionalStudent.get();
            StudentGeneralDto studentGeneralDto = new StudentGeneralDto();
            studentGeneralDto.setId(newStudent.getId());
            studentGeneralDto.setName(newStudent.getName());
            studentGeneralDto.setAddress(newStudent.getAddress());
            logger.info("Found student: {}", studentGeneralDto);
            return ResponseEntity.ok(studentGeneralDto);
        } else {
            logger.warn("Student with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }


    public ResponseEntity<Student> addStudent(CreateStudentDto newStudent) {
        Student student = new Student();
        student.setId(newStudent.getId());
        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());
        student.setAddress(newStudent.getAddress());
        studentRepo.save(student);
        ResponseEntity<Student> responseEntity = ResponseEntity.ok(student);
        return responseEntity;
    }

    public ResponseEntity<String> deleteStudent(String id) {

        Optional<Student> optionalStudent = studentRepo.findById(id);

        if(optionalStudent.isPresent()){
            studentRepo.deleteById(id);
            return ResponseEntity.ok("Successfully Deleted!");
        }
        else {
            logger.warn("Student with ID {} not found for Delete!", id);
            return ResponseEntity.notFound().build();
        }
    }
}