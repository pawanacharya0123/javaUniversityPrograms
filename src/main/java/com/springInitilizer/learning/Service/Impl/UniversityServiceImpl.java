package com.springInitilizer.learning.Service.Impl;

import com.springInitilizer.learning.Dto.DtoMapper.UniversityMapper;
import com.springInitilizer.learning.Dto.UniversityDto;
import com.springInitilizer.learning.Repository.UniversityRepo;
import com.springInitilizer.learning.Service.UniversityService;
import com.springInitilizer.learning.model.University;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepo universityRepo;
    private final UniversityMapper universityMapper;

    public UniversityServiceImpl(UniversityRepo universityRepo, UniversityMapper universityMapper) {
        this.universityRepo = universityRepo;
        this.universityMapper = universityMapper;
    }

    @Override
    public List<UniversityDto> getUniversities() {
        List<University> universities= universityRepo.findAll();
        log.info("In UniversityService: no of universities= "+ universities.size());
        return universities.stream().map(universityMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UniversityDto saveUniversity(UniversityDto universityDto) {
        University university= universityRepo.save(universityMapper.fromDto(universityDto));
        log.info("In UniversityService: University created successfully with id= "+ university.getId());
        return universityMapper.toDto(university);
    }
}
