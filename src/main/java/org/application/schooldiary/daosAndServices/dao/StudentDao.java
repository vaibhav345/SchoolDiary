package org.application.schooldiary.daosAndServices.dao;


import org.application.schooldiary.model.Student;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface StudentDao extends Repository<Student, Integer> {
    List<Student> findAll();

    Optional<Student> findById(int id);

    void save(Student student);

    void delete(Student student);
}
