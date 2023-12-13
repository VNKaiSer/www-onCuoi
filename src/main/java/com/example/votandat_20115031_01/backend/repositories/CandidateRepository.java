package com.example.votandat_20115031_01.backend.repositories;

import com.example.votandat_20115031_01.backend.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("SELECT c FROM Candidate c WHERE c.id IN (SELECT e.candidate.id FROM Experience e WHERE e.workDescription = 'developer' AND e.company like CONCAT('%', :company, '%'))")
    Collection<Candidate> findDeveloperCandidatesByCompany(@Param("company") String company);
}
