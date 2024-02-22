package com.example.tableRelationDemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tableRelationDemo.entity.AddressEntity;

public interface AddressRepo extends JpaRepository<AddressEntity, Integer>{

}
