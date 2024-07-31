package com.dinerofacil.backend.controller;

import com.dinerofacil.backend.model.Referencia;
import com.dinerofacil.backend.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/referencias")
public class ReferenciaController {

    @Autowired
    private ReferenciaService referenciaService;

    @GetMapping
    public List<Referencia> getAllReferencias() {
        return referenciaService.getAllReferencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Referencia> getReferenciaById(@PathVariable int id) {
        Optional<Referencia> referencia = referenciaService.getReferenciaById(id);
        if (referencia.isPresent()) {
            return ResponseEntity.ok(referencia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Referencia createReferencia(@RequestBody Referencia referencia) {
        return referenciaService.saveReferencia(referencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReferencia(@PathVariable int id) {
        referenciaService.deleteReferencia(id);
        return ResponseEntity.noContent().build();
    }
}

