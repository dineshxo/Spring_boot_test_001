package com.example.nex.demo003.Application.Controllers;


import com.example.nex.demo003.Application.dto.request.CreateStudentDto;
import com.example.nex.demo003.Application.dto.response.StudentGeneralDto;
import com.example.nex.demo003.Domain.entity.Student;
import com.example.nex.demo003.Domain.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity<StudentGeneralDto> getStudent(@RequestParam String id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody CreateStudentDto newStudent){
        return studentService.addStudent(newStudent);
    }







}


