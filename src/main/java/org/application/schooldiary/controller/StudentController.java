package org.application.schooldiary.controller;

import org.application.schooldiary.constant.URI;
import org.application.schooldiary.daosAndServices.service.StudentService;
import org.application.schooldiary.model.Student;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;


@RestController
@RequestMapping(value = URI.STUDENTS)
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Student createStudent(@RequestBody Student student) {
        studentService.save(student);

        return student;
    }

    /*@RequestMapping(value = "addStudent.json",  method = RequestMethod.POST)
    public String saveStudent(@RequestBody final Student student) {
        studentService.save(student);

        return "{\"msg\":\"hello\"}";
    }*/

}
