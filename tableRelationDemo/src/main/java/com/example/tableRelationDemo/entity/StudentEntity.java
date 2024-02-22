package com.example.tableRelationDemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="studentEntity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
	@Id
	@GeneratedValue
private int studentId;
private String studentName;
private int studentAge;

//one to one for book
@OneToOne
private BookEntity bookEntity;

//one to many for Address
@OneToMany
private List<AddressEntity> adList=new ArrayList<>();

public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}

public int getStudentAge() {
	return studentAge;
}

public void setStudentAge(int studentAge) {
	this.studentAge = studentAge;
} 


}
