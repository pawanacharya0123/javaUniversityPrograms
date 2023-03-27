package com.springInitilizer.learning.Repository;

import com.springInitilizer.learning.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepo extends JpaRepository<University, Long> {
}
