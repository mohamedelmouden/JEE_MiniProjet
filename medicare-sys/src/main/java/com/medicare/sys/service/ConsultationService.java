package com.medicare.sys.service;

import com.medicare.sys.model.ConsultationPlanifiee;
import com.medicare.sys.model.EtatConsultation;
import com.medicare.sys.model.PraticienSante;
import com.medicare.sys.repository.ConsultationPlanifieeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationPlanifieeRepository consultationRepository;

    public List<ConsultationPlanifiee> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public ConsultationPlanifiee saveConsultation(ConsultationPlanifiee consultation) {
        if (consultation.getStatut() == null) {
            consultation.setStatut(EtatConsultation.PLANIFIEE);
        }
        return consultationRepository.save(consultation);
    }

    public ConsultationPlanifiee getConsultationById(Long id) {
        return consultationRepository.findById(id).orElse(null);
    }

    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }

    public void updateStatut(Long id, EtatConsultation statut) {
        ConsultationPlanifiee consultation = getConsultationById(id);
        if (consultation != null) {
            consultation.setStatut(statut);
            consultationRepository.save(consultation);
        }
    }

    // Filtrage
    public List<ConsultationPlanifiee> filterByMedecin(PraticienSante medecin) {
        return consultationRepository.findByMedecin(medecin);
    }

    public List<ConsultationPlanifiee> filterByStatut(EtatConsultation statut) {
        return consultationRepository.findByStatut(statut);
    }

    public List<ConsultationPlanifiee> filterBySpecialite(String specialite) {
        return consultationRepository.findBySpecialite(specialite);
    }

    public List<ConsultationPlanifiee> filterByDateRange(LocalDateTime start, LocalDateTime end) {
        return consultationRepository.findByDateRange(start, end);
    }

    // Statistiques
    public Map<String, Long> getStatsBySpecialite() {
        return getAllConsultations().stream()
                .collect(Collectors.groupingBy(
                        c -> c.getMedecin().getSpecialiteMedicale(),
                        Collectors.counting()
                ));
    }

    public Map<String, Long> getStatsByMonth() {
        return getAllConsultations().stream()
                .collect(Collectors.groupingBy(
                        c -> c.getDateHeure().getMonth().name() + " " + c.getDateHeure().getYear(),
                        Collectors.counting()
                ));
    }

    public double getNoShowRate() {
        long total = consultationRepository.countTotalConsultations();
        if (total == 0) return 0.0;
        long noShows = consultationRepository.countNoShows();
        return (double) noShows / total * 100;
    }
}
