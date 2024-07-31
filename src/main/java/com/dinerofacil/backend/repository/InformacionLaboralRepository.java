package com.dinerofacil.backend.repository;

import com.dinerofacil.backend.model.InformacionLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionLaboralRepository extends JpaRepository<InformacionLaboral, Integer> {
}