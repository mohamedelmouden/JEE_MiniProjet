package com.medicare.sys.controller;

import com.medicare.sys.model.PraticienSante;
import com.medicare.sys.service.PraticienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/praticiens")
public class PraticienController {
    @Autowired
    private PraticienService praticienService;

    @GetMapping
    public String listPraticiens(Model model) {
        model.addAttribute("praticiens", praticienService.getAllPraticiens());
        return "praticiens/list";
    }

    @GetMapping("/nouveau")
    public String showCreateForm(Model model) {
        model.addAttribute("praticien", new PraticienSante());
        return "praticiens/form";
    }

    @PostMapping("/enregistrer")
    public String savePraticien(@ModelAttribute("praticien") PraticienSante praticien) {
        praticienService.savePraticien(praticien);
        return "redirect:/praticiens";
    }

    @GetMapping("/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("praticien", praticienService.getPraticienById(id));
        return "praticiens/form";
    }

    @GetMapping("/supprimer/{id}")
    public String deletePraticien(@PathVariable Long id) {
        praticienService.deletePraticien(id);
        return "redirect:/praticiens";
    }
}
