package com.medicare.sys.service;

import com.medicare.sys.model.DossierPatient;
import com.medicare.sys.repository.DossierPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private DossierPatientRepository patientRepository;

    public List<DossierPatient> getAllPatients() {
        return patientRepository.findAll();
    }

    public DossierPatient savePatient(DossierPatient patient) {
        return patientRepository.save(patient);
    }

    public DossierPatient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
