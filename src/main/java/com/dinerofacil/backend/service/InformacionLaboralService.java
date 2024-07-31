package com.dinerofacil.backend.service;

import com.dinerofacil.backend.model.InformacionLaboral;
import com.dinerofacil.backend.repository.InformacionLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacionLaboralService {

    @Autowired
    private InformacionLaboralRepository informacionLaboralRepository;

    public List<InformacionLaboral> getAllInformacionLaboral() {
        return informacionLaboralRepository.findAll();
    }

    public Optional<InformacionLaboral> getInformacionLaboralById(int id) {
        return informacionLaboralRepository.findById(id);
    }

    public InformacionLaboral saveInformacionLaboral(InformacionLaboral informacionLaboral) {
        return informacionLaboralRepository.save(informacionLaboral);
    }

    public void deleteInformacionLaboral(int id) {
        informacionLaboralRepository.deleteById(id);
    }
}
