package com.company.cruddemo.dao;

import com.company.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student read(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> readAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> readByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:param", Student.class);
        theQuery.setParameter("param", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student theStudent = entityManager.find(Student.class, id); // or Student theStudent = read(id)
        entityManager.remove(theStudent);
//      or
//        Query theQuery = entityManager.createQuery("DELETE Student WHERE id=:param");
//        theQuery.setParameter("param", id);
//        int rowCount = query.executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
