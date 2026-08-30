package com.medhat.mapper;

import com.medhat.dtos.StudentRequestDTO;
import com.medhat.dtos.StudentResponseDTO;
import com.medhat.entity.StudentEntity;

public class StudentMapper {
    public static StudentEntity toEntity(StudentRequestDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setMajor(dto.getMajor());
        return entity;
    }

    public static StudentResponseDTO toDTO(StudentEntity entity) {
        return new StudentResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getMajor()
        );
    }
}
