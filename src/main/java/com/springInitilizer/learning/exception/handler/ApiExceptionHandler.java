package com.springInitilizer.learning.exception.handler;

import com.springInitilizer.learning.exception.ApiException;
import com.springInitilizer.learning.exception.studentException.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {StudentNotFoundException.class})
    public ResponseEntity<Object> handleApiException(StudentNotFoundException e){
        HttpStatus badReq= HttpStatus.BAD_REQUEST;
        ApiException apiException  = new ApiException(
                e.getMessage(),
                badReq,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, badReq);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler( value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleInvalidArguments(MethodArgumentNotValidException ex){
        Map<String, String> errorMaps= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error-> {
                    errorMaps.put(error.getField(), error.getDefaultMessage());
                }
        );
        return new ResponseEntity<>(errorMaps, HttpStatus.BAD_REQUEST);
    }
}
