package com.dinerofacil.backend.repository;

import com.dinerofacil.backend.model.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenciaRepository extends JpaRepository<Referencia, Integer> {
}