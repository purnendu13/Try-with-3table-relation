package com.example.tableRelationDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tableRelationDemo.entity.StudentEntity;
import com.example.tableRelationDemo.jpa.StudentRepo;

@Service
public class StudentService {


    @Autowired
    private StudentRepo studentRepository;

    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public StudentEntity updateStudent(int id, StudentEntity updatedStudent) {
        Optional<StudentEntity> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            updatedStudent.setStudentId(id);
            return studentRepository.save(updatedStudent);
        } else {
            return null;
        }
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
