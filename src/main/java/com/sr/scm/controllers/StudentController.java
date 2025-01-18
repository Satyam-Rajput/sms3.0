package com.sr.scm.controllers;

import com.sr.scm.dtos.StudentDTO;
import com.sr.scm.entities.Student;
import com.sr.scm.services.StudentService;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Student controller.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Create student response entity.
     *
     * @param studentDTO the student dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO studentDTO) throws SystemException, NotSupportedException {
throw new NullPointerException();
        //        Student student = studentService.saveStudent(studentDTO);
//        return ResponseEntity.ok(student);
    }

    /**
     * Gets student by id.
     *
     * @param id the id
     * @return the student by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) throws Exception{
        throw new NotSupportedException("xyz");
//        Optional<Student> student = studentService.getStudentById(id);
//        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    /**
     * Gets all students.
     *
     * @return the all students
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    /**
     * Update student response entity.
     *
     * @param id         the id
     * @param studentDTO the student dto
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        Student updatedStudent = studentService.updateStudent(id, studentDTO);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete student response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}