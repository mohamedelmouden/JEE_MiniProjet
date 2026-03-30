package com.medicare.sys.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dossiers_patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DossierPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomComplet;

    @Column(unique = true, nullable = false)
    private String numeroIdentite; // CIN

    private LocalDate dateDeNaissance;

    private String typeAssurance;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<ConsultationPlanifiee> consultations;
}
