package org.application.schooldiary.serviceImple;

import org.application.schooldiary.daosAndServices.dao.TeacherDao;
import org.application.schooldiary.daosAndServices.service.TeacherService;
import org.application.schooldiary.model.Teacher;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    @Override
    public Optional<Teacher> findById(int id) {
        return teacherDao.findById(id);
    }

    @Override
    public void save(Teacher teacher) {
        LOGGER.info("In Service Class");
        LOGGER.info(teacher.toString());
        teacherDao.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.save(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherDao.delete(teacher);
    }
}
