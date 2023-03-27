package com.springInitilizer.learning.Service;

import com.springInitilizer.learning.Dto.StudentDto;

import java.util.List;

//@Service
public interface StudentService {
    List<StudentDto> getAllStudents() ;

    StudentDto getStudent(Long id);

    StudentDto createStudent(StudentDto studentDto);

    void deleteStudent(Long id);
}
