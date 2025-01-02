package com.seroter.school_management.controllers;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seroter.school_management.models.Student;
import com.seroter.school_management.services.StudentService;
import com.seroter.school_management.utils.House;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public boolean createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return true;
    }

    @GetMapping("/getNotSeatedStudents/{isSeated}")
    public List<Student> getStudentsNotSeated(@PathVariable("isSeated") boolean isSeated){
        return studentService.findStudentNotSeated(isSeated);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") ObjectId id){
        System.out.println(id);
        return studentService.findStudentById(id).orElse(null);
    }

    @GetMapping("/house/{house}")
    public List<Student> getStudentsByHouse(@PathVariable("house") House house) {
        return studentService.findStudentsByHouse(house);
    }

    @GetMapping("/class/{className}")
    public List<Student> getStudentsByClassName(@PathVariable("className") String className) {
        return studentService.findStudentsByClassName(className);
    }

    @GetMapping("/house/{house}/class/{className}")
    public List<Student> getStudentsByHouseAndClass(@PathVariable("house") House house, @PathVariable("className") String className) {
        return studentService.findStudentsByHouseAndClass(house, className);
    }
}
