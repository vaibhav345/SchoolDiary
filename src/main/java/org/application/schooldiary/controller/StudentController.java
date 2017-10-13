package org.application.schooldiary.controller;

import org.application.schooldiary.daosAndServices.service.StudentService;
import org.application.schooldiary.model.Student;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class StudentController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/addStudent.json",  method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveStudent(@RequestBody final Student student, BindingResult result, HttpServletRequest request) {
        //LOGGER.info("In Controller Class");
        //LOGGER.info(student.toString());

        studentService.save(student);

        return "{\"msg\":\"hello\"}";
    }
}
