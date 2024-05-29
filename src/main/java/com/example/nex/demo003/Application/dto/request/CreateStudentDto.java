package com.example.nex.demo003.Application.dto.request;

import lombok.Data;

@Data
public class CreateStudentDto {
    private String id;
    private String name;
    private String email;
    private String address;
}
