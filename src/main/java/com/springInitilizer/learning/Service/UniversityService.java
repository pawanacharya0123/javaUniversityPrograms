package com.springInitilizer.learning.Service;

import com.springInitilizer.learning.Dto.UniversityDto;

import java.util.List;

public interface UniversityService {
    List<UniversityDto> getUniversities();

    UniversityDto saveUniversity(UniversityDto universityDto);
}
