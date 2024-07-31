package com.dinerofacil.backend.service;

import com.dinerofacil.backend.model.Referencia;
import com.dinerofacil.backend.repository.ReferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferenciaService {

    @Autowired
    private ReferenciaRepository referenciaRepository;

    public List<Referencia> getAllReferencias() {
        return referenciaRepository.findAll();
    }

    public Optional<Referencia> getReferenciaById(int id) {
        return referenciaRepository.findById(id);
    }

    public Referencia saveReferencia(Referencia referencia) {
        return referenciaRepository.save(referencia);
    }

    public void deleteReferencia(int id) {
        referenciaRepository.deleteById(id);
    }
}
