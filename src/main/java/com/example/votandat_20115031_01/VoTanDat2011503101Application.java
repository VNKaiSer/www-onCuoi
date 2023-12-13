package com.example.votandat_20115031_01;

import com.example.votandat_20115031_01.backend.enums.Roles;
import com.example.votandat_20115031_01.backend.models.Candidate;
import com.example.votandat_20115031_01.backend.models.Experience;
import com.example.votandat_20115031_01.backend.repositories.CandidateRepository;
import com.example.votandat_20115031_01.backend.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EntityScan(basePackages = "com.example.votandat_20115031_01")
public class VoTanDat2011503101Application {

    public static void main(String[] args) {
        SpringApplication.run(VoTanDat2011503101Application.class, args);
    }

    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    ExperienceRepository experienceRepository;
    @Bean
    CommandLineRunner initData() {
        return args -> {
            Random rdn = new Random();
            for (int i = 1; i < 5; i++) {
                Candidate can = new Candidate("032967"+ rdn.nextInt(i),rdn.nextInt()+ "@gmail.com", i+ "Name",null);
                can.setId(i);
                candidateRepository.save(can);
                List<Experience> experiences = List.of(
                        new Experience("Job" + rdn.nextInt(i), Roles.EXCUTIVE, LocalDate.of(2023, 2, i), LocalDate.of(2023, i+2, i+1),can),
                        new Experience("Job" + rdn.nextInt(i), Roles.STAFF, LocalDate.of(2023, 2, i), LocalDate.of(2023, i+2, i+1),can),
                new Experience("Job" + rdn.nextInt(i), Roles.ADMINSTRATION, LocalDate.of(2023, 2, i), LocalDate.of(2023, i+2, i+1),can)
                );
                experienceRepository.saveAll(experiences.stream().toList());
                can.setExperiences(experiences);
                candidateRepository.save(can);

            }
        };
    }

}
