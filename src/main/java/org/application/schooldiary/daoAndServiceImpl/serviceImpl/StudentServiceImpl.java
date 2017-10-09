package org.application.schooldiary.daoAndServiceImpl.serviceImpl;
import org.application.schooldiary.daosAndServices.dao.GenericDao;
import org.application.schooldiary.daosAndServices.dao.StudentDao;
import org.application.schooldiary.daosAndServices.service.StudentService;
import org.application.schooldiary.model.Student;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service("studentService")
@Transactional
public class StudentServiceImpl extends GenericServiceImpl<Student, Integer> implements StudentService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(int id) {
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
        studentDao.update(student);
    }

    @Override
    public void delete(Student student) {
        studentDao.delete(student);
    }

    @Override
    protected GenericDao<Student, Integer> getDao() {
        return studentDao;
    }
}
