package com.example.nex.demo003.External.repository;

import com.example.nex.demo003.Domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepo extends JpaRepository<Student, String> {

    Optional<Student> findByName(String name);

}
