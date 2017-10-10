package org.application.schooldiary.daoAndServiceImpl.daoImpl;

import org.application.schooldiary.daosAndServices.dao.StudentDao;
import org.application.schooldiary.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class StudentDaoImpl extends GenericJpaDao<Student, Integer> implements StudentDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Instantiates a new Student dao.
     */
    public StudentDaoImpl() {
        super(Student.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Student> findAll() {
        List<Student> results = entityManager.createQuery("select s from Student s order by s.id ASC ", Student.class).getResultList();
        return results;
    }

    @Override
    public Student findById(int id) {
        return (Student) entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student student) {

        LOGGER.info("In Dao Class");
        persist(student);
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public void delete(Student student) {
        entityManager.remove(student);
    }
}
