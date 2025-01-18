package com.sr.scm.services;

import com.sr.scm.dtos.StudentDTO;
import com.sr.scm.entities.Student;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.SystemException;

import java.util.List;
import java.util.Optional;

/**
 * The interface Student service.
 */
public interface StudentService {
    /**
     * Save student student.
     *
     * @param student the student
     * @return the student
     */
    Student saveStudent(StudentDTO student) throws SystemException, NotSupportedException;

    /**
     * Gets student by id.
     *
     * @param id the id
     * @return the student by id
     */
    Optional<Student> getStudentById(Long id);

    /**
     * Gets all students.
     *
     * @return the all students
     */
    List<Student> getAllStudents();

    /**
     * Update student student.
     *
     * @param id      the id
     * @param student the student
     * @return the student
     */
    Student updateStudent(Long id, StudentDTO student);

    /**
     * Delete student.
     *
     * @param id the id
     */
    void deleteStudent(Long id);
}