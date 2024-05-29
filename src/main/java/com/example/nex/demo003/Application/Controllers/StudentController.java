package com.example.nex.demo003.Application.Controllers;


import com.example.nex.demo003.Application.dto.response.StudentGeneralDto;
import com.example.nex.demo003.Domain.entity.Student;
import com.example.nex.demo003.Domain.service.StudentService;
import com.example.nex.demo003.External.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity<StudentGeneralDto> getStudent(@RequestParam String id) {



    }




}


