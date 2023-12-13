package com.example.votandat_20115031_01.backend.services;

import com.example.votandat_20115031_01.backend.models.Candidate;

import java.util.Collection;
import java.util.Optional;

public interface CandidateService {
    Collection<Candidate> getAllCandidate();
    Candidate getCandidateById(long id);

    Collection<Candidate> getCandidateReport(String company);
    Collection<Candidate> findCandidateThan5Exp();

}
