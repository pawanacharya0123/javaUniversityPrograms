package com.springInitilizer.learning.controller;

import com.springInitilizer.learning.Dto.StudentDto;
import com.springInitilizer.learning.Service.StudentService;
import com.springInitilizer.learning.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentApi {

    private final StudentService studentService;
    private final StudentDto dummyStudentDto= null;

    public StudentApi(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents(){
        log.info("request successful reached the controller: getAllStudents");
        List<StudentDto> studentsToReturn= studentService.getAllStudents();
        return new ResponseEntity<>(studentsToReturn, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long id){
        log.info("request successful reached the controller: getStudent, with id "+ id);
        StudentDto studentDto= studentService.getStudent(id);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentDto studentDtoReq){
        log.info("request successful reached the controller: createStudent, with requestBody "+ studentDtoReq);
        StudentDto studentDto= studentService.createStudent(studentDtoReq);
        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(dummyStudentDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteStudent(@PathVariable("id") Long id){
        log.info("request successful reached the controller: getStudent, with id "+ id);
        studentService.deleteStudent(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
