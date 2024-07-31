package com.dinerofacil.backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class InformacionLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer informacionLaboralID;

    @ManyToOne
    @JoinColumn(name = "clienteID")
    private Cliente cliente;

    private String nitEmpresa;
    private String nombreEmpresa;
    private String direccion;
    private String telefono;
    private String cargo;
    private Date fechaVinculacion;




}
