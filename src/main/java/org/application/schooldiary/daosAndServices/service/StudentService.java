package org.application.schooldiary.daosAndServices.service;

import org.application.schooldiary.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Optional<Student> findById(int id);

    void save(Student student);

    void update(Student student);

    void delete(Student student);
}
