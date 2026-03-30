package com.medicare.sys.repository;

import com.medicare.sys.model.ConsultationPlanifiee;
import com.medicare.sys.model.EtatConsultation;
import com.medicare.sys.model.PraticienSante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultationPlanifieeRepository extends JpaRepository<ConsultationPlanifiee, Long> {
    
    List<ConsultationPlanifiee> findByMedecin(PraticienSante medecin);
    
    List<ConsultationPlanifiee> findByStatut(EtatConsultation statut);
    
    @Query("SELECT c FROM ConsultationPlanifiee c WHERE c.dateHeure BETWEEN :start AND :end")
    List<ConsultationPlanifiee> findByDateRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
    
    @Query("SELECT c FROM ConsultationPlanifiee c WHERE c.medecin.specialiteMedicale = :specialite")
    List<ConsultationPlanifiee> findBySpecialite(@Param("specialite") String specialite);

    @Query("SELECT COUNT(c) FROM ConsultationPlanifiee c WHERE c.statut = 'ABSENT'")
    long countNoShows();

    @Query("SELECT COUNT(c) FROM ConsultationPlanifiee c")
    long countTotalConsultations();
}
