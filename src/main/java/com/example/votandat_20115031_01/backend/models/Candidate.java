package com.example.votandat_20115031_01.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="can_id")
    private long id;

    private String phone;
    private String email;
    private String fullName;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<Experience> experiences;

    public Candidate(long id) {
        this.id = id;
    }

    public Candidate(String phone, String email, String fullName, List<Experience> experiences) {
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.experiences = experiences;
    }
}
