package com.medhat.exceptions;

public class GlobalExceptionManager extends RuntimeException {
  public GlobalExceptionManager(String message) {
    super(message);
  }
}
