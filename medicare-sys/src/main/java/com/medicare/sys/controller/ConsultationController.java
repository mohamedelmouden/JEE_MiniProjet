package com.medicare.sys.controller;

import com.medicare.sys.model.ConsultationPlanifiee;
import com.medicare.sys.model.EtatConsultation;
import com.medicare.sys.service.ConsultationService;
import com.medicare.sys.service.PatientService;
import com.medicare.sys.service.PraticienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultations")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PraticienService praticienService;

    @GetMapping
    public String listConsultations(@RequestParam(required = false) String specialite,
                                    @RequestParam(required = false) EtatConsultation statut,
                                    Model model) {
        List<ConsultationPlanifiee> consultations;
        if (specialite != null && !specialite.isEmpty()) {
            consultations = consultationService.filterBySpecialite(specialite);
        } else if (statut != null) {
            consultations = consultationService.filterByStatut(statut);
        } else {
            consultations = consultationService.getAllConsultations();
        }
        
        model.addAttribute("consultations", consultations);
        model.addAttribute("specialites", praticienService.getAllSpecialites());
        model.addAttribute("statuts", EtatConsultation.values());
        return "consultations/list";
    }

    @GetMapping("/nouveau")
    public String showCreateForm(Model model) {
        model.addAttribute("consultation", new ConsultationPlanifiee());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("praticiens", praticienService.getAllPraticiens());
        model.addAttribute("statuts", EtatConsultation.values());
        return "consultations/form";
    }

    @PostMapping("/enregistrer")
    public String saveConsultation(@ModelAttribute("consultation") ConsultationPlanifiee consultation) {
        consultationService.saveConsultation(consultation);
        return "redirect:/consultations";
    }

    @GetMapping("/statut/{id}/{statut}")
    public String updateStatut(@PathVariable Long id, @PathVariable EtatConsultation statut) {
        consultationService.updateStatut(id, statut);
        return "redirect:/consultations";
    }

    @GetMapping("/stats")
    public String showStats(Model model) {
        model.addAttribute("statsSpecialite", consultationService.getStatsBySpecialite());
        model.addAttribute("statsMois", consultationService.getStatsByMonth());
        model.addAttribute("noShowRate", consultationService.getNoShowRate());
        return "consultations/stats";
    }

    @GetMapping("/supprimer/{id}")
    public String deleteConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
        return "redirect:/consultations";
    }
}
