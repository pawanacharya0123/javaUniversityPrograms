package com.springInitilizer.learning.Service.Impl;

import com.springInitilizer.learning.Dto.DtoMapper.StudentMapper;
import com.springInitilizer.learning.Dto.StudentDto;
import com.springInitilizer.learning.Repository.StudentRepo;
import com.springInitilizer.learning.Service.StudentService;
import com.springInitilizer.learning.exception.studentException.StudentNotFoundException;
import com.springInitilizer.learning.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepo.findAll();
        log.info("In StudentService: no of students= "+ students.size());
        return students.stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudent(Long id) {
        Optional<Student> studentOptional= studentRepo.findById(id);
        if (studentOptional.isPresent()){
            Student student= studentOptional.get();
            log.info("In StudentService: student found= "+ student);
            return studentMapper.toDto(student);
        }
        else{
            log.error("In StudentService: Student not found for id= "+ id);
            throw new StudentNotFoundException("Student not found with id: "+ id);
        }

    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student= studentMapper.fromDto(studentDto);
        log.info("In StudentService: Student created successfully with id= "+ student.getId());
        return studentMapper
                .toDto(studentRepo.save(student));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
