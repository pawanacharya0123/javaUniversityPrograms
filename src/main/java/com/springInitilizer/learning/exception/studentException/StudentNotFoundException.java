package com.springInitilizer.learning.exception.studentException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException  {

    public StudentNotFoundException(String message) {
        super(message);
    }
}
