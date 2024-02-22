package com.example.tableRelationDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tableRelationDemo.Service.StudentService;
import com.example.tableRelationDemo.entity.StudentEntity;
@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {
        StudentEntity createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable("id") int id, @RequestBody StudentEntity updatedStudent) {
        StudentEntity student = studentService.updateStudent(id, updatedStudent);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
