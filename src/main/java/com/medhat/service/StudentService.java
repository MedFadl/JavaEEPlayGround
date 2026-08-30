package com.medhat.service;

import com.medhat.dtos.StudentRequestDTO;
import com.medhat.dtos.StudentResponseDTO;
import com.medhat.entity.StudentEntity;
import com.medhat.exceptions.StudentNotFoundException;
import com.medhat.mapper.StudentMapper;
import com.medhat.repository.StudentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional


public class StudentService {
    private static final Logger LOGGER = Logger.getLogger(StudentService.class.getName());


    @Inject
    StudentRepository studentRepository;


    public List<StudentResponseDTO> findAll() {
        LOGGER.info("Fetching all students :D");
        List<StudentEntity> entities = studentRepository.findAll();
        LOGGER.info(() -> "Found " + entities.size() + " students :DDD");
        return entities
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO findById(Long id) {
        LOGGER.info("Fetching student with id :D " + id);
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));
        return StudentMapper.toDTO(student);
    }


    public StudentResponseDTO create(StudentRequestDTO requestDto) {
        LOGGER.info("Creating student :D");
        StudentEntity student = StudentMapper.toEntity(requestDto);
        studentRepository.save(student);
        LOGGER.info(() -> "Student created with id : " + student.getId());
        return StudentMapper.toDTO(student);
    }
}
