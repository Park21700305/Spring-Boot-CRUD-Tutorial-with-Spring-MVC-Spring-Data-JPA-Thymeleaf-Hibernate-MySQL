package com.walab.SpringBootCRUDTutorial.service;

import com.walab.SpringBootCRUDTutorial.entity.Student;
import com.walab.SpringBootCRUDTutorial.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for id " + id));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student studentDetails) {
        Student updatedStudent = Student.builder()
                .firstName(studentDetails.getFirstName())
                .lastName(studentDetails.getLastName())
                .email(studentDetails.getEmail())
                .build();

        return studentRepository.save(updatedStudent);
    }

    public void deleteStudentById(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found for id " + id));
        studentRepository.deleteById(id);
    }

}
