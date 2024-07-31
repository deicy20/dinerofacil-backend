package com.dinerofacil.backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "usuario_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer clienteID;
    private String tipoDocumento;
    private String numeroDocumento;
    private String apellidos;
    private String residencia;
    private String ciudad;
    private String telefono;


}
