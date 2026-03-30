package com.medicare.sys.controller;

import com.medicare.sys.model.DossierPatient;
import com.medicare.sys.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients/list";
    }

    @GetMapping("/nouveau")
    public String showCreateForm(Model model) {
        model.addAttribute("patient", new DossierPatient());
        return "patients/form";
    }

    @PostMapping("/enregistrer")
    public String savePatient(@ModelAttribute("patient") DossierPatient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        return "patients/form";
    }

    @GetMapping("/supprimer/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}
