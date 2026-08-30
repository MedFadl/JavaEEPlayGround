package com.medhat.repository;

import com.medhat.entity.StudentEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class StudentRepository {

    @PersistenceContext(unitName = "StudentPU")
    private EntityManager em;


    public List<StudentEntity> findAll() {
        return em.createQuery("Select s from StudentEntity s", StudentEntity.class).getResultList();

    }

    public Optional<StudentEntity> findById(Long id) {
        return Optional.ofNullable(em.find(StudentEntity.class, id));
    }

    public void save(StudentEntity student) {
        em.persist(student);
    }

}
