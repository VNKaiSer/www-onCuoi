package com.example.votandat_20115031_01.backend.repositories;

import com.example.votandat_20115031_01.backend.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
