package org.application.schooldiary.controller;

import org.application.schooldiary.constant.URI;
import org.application.schooldiary.daosAndServices.service.TeacherService;
import org.application.schooldiary.model.Teacher;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = URI.TEACHERS)
@CrossOrigin(origins = "http://localhost:3000")
public class TeacherController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        LOGGER.info("In Register Function: " + teacher.getUser_name());
        teacherService.save(teacher);

        return teacher;
    }
}
