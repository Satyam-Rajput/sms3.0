package com.sr.scm.entities;

import com.sr.scm.dtos.StudentDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.util.Date;

/**
 * The type Student.
 *
 * @author Satyam
 * @since 1.0
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String rollNo;
    private String email;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;

    // Getters and Setters

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets roll no.
     *
     * @return the roll no
     */
    public String getRollNo() {
        return rollNo;
    }

    /**
     * Sets roll no.
     *
     * @param rollNo the roll no
     */
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //parse student from student DTO
    public static Student parseStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setRollNo(studentDTO.getRollNo());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setAddress(studentDTO.getAddress());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        return student;
    }

    //parse Student DTO from Student
    public static StudentDTO parseStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setRollNo(student.getRollNo());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPhoneNumber(student.getPhoneNumber());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setDateOfBirth(student.getDateOfBirth());
        studentDTO.setId(student.getId());
        return studentDTO;
    }


}