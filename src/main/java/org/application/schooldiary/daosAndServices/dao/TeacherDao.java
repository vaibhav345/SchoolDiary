package org.application.schooldiary.daosAndServices.dao;

import org.application.schooldiary.model.Teacher;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface TeacherDao extends Repository<Teacher, Integer> {
    List<Teacher> findAll();

    Optional<Teacher> findById(int id);

    void save(Teacher teacher);

    void delete(Teacher teacher);
}
