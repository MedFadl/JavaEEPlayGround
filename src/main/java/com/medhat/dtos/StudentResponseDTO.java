package com.medhat.dtos;

public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String major;

    public StudentResponseDTO(Long id, String name, String email, String major) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
