package com.example.votandat_20115031_01.backend.models;

import com.example.votandat_20115031_01.backend.enums.Roles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="exp_id")
    private long id;

    private String workDescription;
    private Roles role;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience(long id) {
        this.id = id;
    }

    public Experience(String workDescription, Roles role, LocalDate fromDate, LocalDate toDate, Candidate candidate) {
        this.workDescription = workDescription;
        this.role = role;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Experience[" +
                "id=" + id +
                ", workDescription='" + workDescription + '\'' +
                ", role=" + role +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", candidate=" + candidate +
                ']';
    }
}
