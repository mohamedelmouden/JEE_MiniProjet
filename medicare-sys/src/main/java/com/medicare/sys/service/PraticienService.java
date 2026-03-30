package com.medicare.sys.service;

import com.medicare.sys.model.PraticienSante;
import com.medicare.sys.repository.PraticienSanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PraticienService {
    @Autowired
    private PraticienSanteRepository praticienRepository;

    public List<PraticienSante> getAllPraticiens() {
        return praticienRepository.findAll();
    }

    public PraticienSante savePraticien(PraticienSante praticien) {
        return praticienRepository.save(praticien);
    }

    public PraticienSante getPraticienById(Long id) {
        return praticienRepository.findById(id).orElse(null);
    }

    public void deletePraticien(Long id) {
        praticienRepository.deleteById(id);
    }

    public List<String> getAllSpecialites() {
        return praticienRepository.findAll().stream()
                .map(PraticienSante::getSpecialiteMedicale)
                .distinct()
                .collect(Collectors.toList());
    }
}
