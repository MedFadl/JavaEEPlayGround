package com.medhat;

import com.medhat.model.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class StudentService {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;

    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public Student create(Student student) {
        em.persist(student);
        return student;
    }
}
