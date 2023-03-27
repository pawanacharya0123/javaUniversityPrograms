package com.springInitilizer.learning.Dto.DtoMapper;

import com.springInitilizer.learning.Dto.StudentDto;
import com.springInitilizer.learning.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private final ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Student fromDto(StudentDto studentDto){

        Student student = modelMapper.map(studentDto, Student.class);
        return student;
    }

    public StudentDto toDto(Student student){
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        return studentDto;
    }
}
