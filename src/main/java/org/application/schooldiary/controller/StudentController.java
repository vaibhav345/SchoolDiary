package org.application.schooldiary.controller;

import org.application.schooldiary.commonFunctions.CommonFunctions;
import org.application.schooldiary.constant.URI;
import org.application.schooldiary.daosAndServices.service.StudentService;
import org.application.schooldiary.model.Student;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.lang.reflect.Field;
import java.util.List;


@RestController
@RequestMapping(value = URI.STUDENTS)
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;
    CommonFunctions commonFunctions = new CommonFunctions();

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity createStudent(@RequestBody Student student) {
        LOGGER.info("In Register Function: " + student.getUser_name());

        //Validate Email
        if( commonFunctions.isValid(student.getEmail()) ) {
            studentService.save(student);
            return ResponseEntity.ok("Record added successfully.");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email ID entered is not valid!");
    }

    /*@RequestMapping(value = "addStudent.json",  method = RequestMethod.POST)
    public String saveStudent(@RequestBody final Student student) {
        studentService.save(student);

        return "{\"msg\":\"hello\"}";
    }*/

}
