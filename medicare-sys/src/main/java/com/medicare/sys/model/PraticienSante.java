package com.medicare.sys.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "praticiens_sante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PraticienSante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomComplet;

    @Column(nullable = false)
    private String specialiteMedicale;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
    private List<ConsultationPlanifiee> consultations;
}
