package com.sr.scm.services.impl;

import com.sr.scm.dtos.StudentDTO;
import com.sr.scm.entities.Student;
import com.sr.scm.repos.StudentRepository;
import com.sr.scm.services.StudentService;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;
import java.util.Optional;

/**
 * The type Student service.
 *
 * @author Satyam
 * @since 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Override
    public Student saveStudent(StudentDTO studentDTO) throws SystemException, NotSupportedException {
        Student student = new Student();

        student = Student.parseStudent(studentDTO);
        Student s=studentRepository.save(student);
        return s;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, StudentDTO student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setName(student.getName());
            updatedStudent.setRollNo(student.getRollNo());
            updatedStudent.setEmail(student.getEmail());
            updatedStudent.setPhoneNumber(student.getPhoneNumber());
            updatedStudent.setAddress(student.getAddress());
            updatedStudent.setDateOfBirth(student.getDateOfBirth());
            return studentRepository.save(updatedStudent);
        } else {
            return null;
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}