package com.dinerofacil.backend.controller;

import com.dinerofacil.backend.dto.InformacionLaboralDto;
import com.dinerofacil.backend.model.Cliente;
import com.dinerofacil.backend.model.InformacionLaboral;
import com.dinerofacil.backend.service.InformacionLaboralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/informacionlaboral")
public class InformacionLaboralController {

    @Autowired
    private InformacionLaboralService informacionLaboralService;

    @GetMapping
    public List<InformacionLaboral> getAllInformacionLaboral() {
        return informacionLaboralService.getAllInformacionLaboral();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacionLaboral> getInformacionLaboralById(@PathVariable int id) {
        Optional<InformacionLaboral> informacionLaboral = informacionLaboralService.getInformacionLaboralById(id);
        if (informacionLaboral.isPresent()) {
            return ResponseEntity.ok(informacionLaboral.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public InformacionLaboral createInformacionLaboral(@RequestBody InformacionLaboralDto informacionLaboralDto) {
        InformacionLaboral informacionLaboral = InformacionLaboral.builder()
                .cliente(Cliente.builder()
                        .clienteID(informacionLaboralDto.getClienteID())
                        .build())
                .nitEmpresa(informacionLaboralDto.getNitEmpresa())
                .nombreEmpresa(informacionLaboralDto.getNombreEmpresa())
                .direccion(informacionLaboralDto.getDireccion())
                .telefono(informacionLaboralDto.getTelefono())
                .cargo(informacionLaboralDto.getCargo())
                .fechaVinculacion(informacionLaboralDto.getFechaVinculacion())
                .build();
        return informacionLaboralService.saveInformacionLaboral(informacionLaboral);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformacionLaboral(@PathVariable int id) {
        informacionLaboralService.deleteInformacionLaboral(id);
        return ResponseEntity.noContent().build();
    }
}
