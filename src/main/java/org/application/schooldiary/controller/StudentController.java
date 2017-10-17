package org.application.schooldiary.controller;

import org.application.schooldiary.daosAndServices.service.StudentService;
import org.application.schooldiary.model.Student;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "addStudent.json",  method = RequestMethod.POST)
    public String saveStudent(@RequestBody final Student student) {
        studentService.save(student);

        return "{\"msg\":\"hello\"}";
    }
}
