package com.example.votandat_20115031_01.backend.services.impl;

import com.example.votandat_20115031_01.backend.models.Candidate;
import com.example.votandat_20115031_01.backend.repositories.CandidateRepository;
import com.example.votandat_20115031_01.backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired private CandidateRepository repository;
    @Override
    public Collection<Candidate> getAllCandidate() {
        return repository.findAll();
    }

    @Override
    public Candidate getCandidateById(long id) {
        Optional<Candidate> can = repository.findById(id);
        return can.orElse(null);
    }

    @Override
    public Collection<Candidate> getCandidateReport(String company) {
        return repository.findDeveloperCandidatesByCompany(company);
    }

    @Override
    public Collection<Candidate> findCandidateThan5Exp() {
        List<Candidate> candidates = repository.findAll();
        Collection<Candidate> result = new ArrayList<>();
        for (Candidate can:
             candidates) {
            can.getExperiences().forEach(experience -> {
               if (Period.between(experience.getFromDate(), experience.getToDate()).getYears() >= 5){
                   result.add(can);
               }
            });
        }
        return result;
    }
}
