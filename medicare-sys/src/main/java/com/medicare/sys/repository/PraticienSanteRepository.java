package com.medicare.sys.repository;

import com.medicare.sys.model.PraticienSante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PraticienSanteRepository extends JpaRepository<PraticienSante, Long> {
    List<PraticienSante> findBySpecialiteMedicale(String specialite);
}
