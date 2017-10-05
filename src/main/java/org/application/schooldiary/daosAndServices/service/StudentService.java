package org.application.schooldiary.daosAndServices.service;

import org.application.schooldiary.model.Student;

import java.util.List;

public interface StudentService extends GenericService<Student, Integer> {
    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void update(Student student);

    void delete(Student student);
}
