package org.application.schooldiary.daosAndServices.service;

import org.application.schooldiary.model.Teacher;
import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAll();

    Optional<Teacher> findById(int id);

    void save(Teacher teacher);

    void update(Teacher teacher);

    void delete(Teacher teacher);
}
