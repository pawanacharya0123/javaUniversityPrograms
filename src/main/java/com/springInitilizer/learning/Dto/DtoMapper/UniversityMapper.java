package com.springInitilizer.learning.Dto.DtoMapper;

import com.springInitilizer.learning.Dto.UniversityDto;
import com.springInitilizer.learning.model.University;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UniversityMapper {

    private final ModelMapper modelMapper;

    public UniversityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public University fromDto(UniversityDto universityDto){
        log.info("IN UniversityMapper-fromDto: Request-universityDTO:  "+ universityDto);
//        ModelMapper modelMapper = new ModelMapper();
        University university = modelMapper.map(universityDto, University.class);
        log.info("IN UniversityMapper-fromDto: mapped-university:  "+ university);
        return university;
    }

    public UniversityDto toDto(University university){
        log.info("IN UniversityMapper-toDto: Request-university:  "+ university);
//        ModelMapper modelMapper = new ModelMapper();
        UniversityDto universityDto = modelMapper.map(university, UniversityDto.class);
        log.info("IN UniversityMapper-toDto: mapped-universityDTO:  "+ university);
        return universityDto;
    }
}
