package com.example.tableRelationDemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tableRelationDemo.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, Integer>{

}
