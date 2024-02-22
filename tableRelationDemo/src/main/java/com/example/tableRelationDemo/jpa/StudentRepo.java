package com.example.tableRelationDemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tableRelationDemo.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer>{

}
