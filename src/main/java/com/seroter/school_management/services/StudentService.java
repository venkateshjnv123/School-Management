package com.seroter.school_management.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.seroter.school_management.models.Student;
import com.seroter.school_management.respository.StudentRepository;
import com.seroter.school_management.utils.House;

@Service
@Component
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll(); 
    }

    public List<Student> findStudentNotSeated(boolean isSeated){
        return studentRepository.findByIsSeated(isSeated);
    }

    public Optional<Student> findStudentById(ObjectId id) {
        return studentRepository.findById(id);
    }

    public List<Student> findStudentsByHouse(House house) {
        return studentRepository.findByHouse(house);
    }

    public List<Student> findStudentsByClassName(String className) {
        return studentRepository.findByClassName(className);
    }

    public List<Student> findStudentsByHouseAndClass(House house, String className) {
        return studentRepository.findByHouseAndClassName(house, className);
    }

}
