package org.application.schooldiary.controller;

import org.application.schooldiary.constant.URI;
import org.application.schooldiary.daosAndServices.service.TeacherService;
import org.application.schooldiary.model.Teacher;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.application.schooldiary.commonFunctions.CommonFunctions;


@RestController
@RequestMapping(value = URI.TEACHERS)
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

    private TeacherService teacherService;
    CommonFunctions commonFunctions = new CommonFunctions();

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity createTeacher(@RequestBody Teacher teacher) {
        LOGGER.info("In Register Function: " + teacher.getUser_name());

        //Validate Email
        if( commonFunctions.isValid(teacher.getEmail()) ) {
            teacherService.save(teacher);
            return ResponseEntity.ok("Record added successfully.");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email ID entered is not valid!");
    }
}
