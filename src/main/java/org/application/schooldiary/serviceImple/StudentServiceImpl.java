package org.application.schooldiary.serviceImple;
import org.application.schooldiary.daosAndServices.dao.StudentDao;
import org.application.schooldiary.daosAndServices.service.StudentService;
import org.application.schooldiary.model.Student;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public void save(Student student) {
        LOGGER.info("In Service Class");
        LOGGER.info(student.toString());
        studentDao.save(student);
    }

    @Override
    public void update(Student student) {
        studentDao.save(student);
    }

    @Override
    public void delete(Student student) {
        studentDao.delete(student);
    }
}
