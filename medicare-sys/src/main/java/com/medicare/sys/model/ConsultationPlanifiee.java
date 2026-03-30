package com.medicare.sys.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultations_planifiees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultationPlanifiee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateHeure;

    @Enumerated(EnumType.STRING)
    private EtatConsultation statut;

    private String motifConsultation;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private DossierPatient patient;

    @ManyToOne
    @JoinColumn(name = "medecin_id", nullable = false)
    private PraticienSante medecin;
}
