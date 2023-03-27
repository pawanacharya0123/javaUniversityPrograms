package com.springInitilizer.learning.controller;

import com.springInitilizer.learning.Dto.DtoMapper.UniversityMapper;
import com.springInitilizer.learning.Dto.UniversityDto;
import com.springInitilizer.learning.Service.UniversityService;
import com.springInitilizer.learning.model.University;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/universities")
@Slf4j @Validated
public class UniversityApi {

    private final UniversityService universityService;
    private final UniversityMapper universityMapper;

    public UniversityApi(UniversityService universityService, UniversityMapper universityMapper) {
        this.universityService = universityService;
        this.universityMapper = universityMapper;
    }

    @GetMapping
    public ResponseEntity<List<UniversityDto>> getUniversities(){
        List<UniversityDto> universitiesToReturn=universityService.getUniversities();
        return new ResponseEntity<>(universitiesToReturn, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UniversityDto> saveUniversity( @Valid @RequestBody University universityReq){
        log.info("In API layer: Uni DTO = "+ universityReq);
        UniversityDto universityDto= universityService.saveUniversity(universityMapper.toDto( universityReq));
        return new ResponseEntity<>(universityDto, HttpStatus.CREATED);
    }
}
