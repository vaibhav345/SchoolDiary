package org.application.schooldiary.daoAndServiceImpl.daoImpl;

import org.application.schooldiary.daosAndServices.dao.StudentDao;
import org.application.schooldiary.model.Student;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class StudentDaoImpl extends GenericJpaDao<Student, Integer> implements StudentDao {

    @PersistenceContext(unitName = "schoolDiaryData")
    EntityManager entityManager;

    /**
     * Instantiates a new Student dao.
     */
    protected StudentDaoImpl(Class<Student> clazz) {
        super(Student.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Student> findAll() {
        List<Student> results = entityManager.createQuery("select s from STUDENT s order by s.id ASC ", Student.class).getResultList();
        return results;
    }

    @Override
    public Student findById(int id) {
        return (Student) entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
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
