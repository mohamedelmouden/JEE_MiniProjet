package com.medicare.sys.repository;

import com.medicare.sys.model.DossierPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierPatientRepository extends JpaRepository<DossierPatient, Long> {
}
