package com.medhat.exceptions;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String s) {
        super(s);
    }
}
