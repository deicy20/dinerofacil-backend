package com.dinerofacil.backend.dto;

import com.dinerofacil.backend.model.Cliente;
import jakarta.persistence.*;

import java.util.Date;

public class InformacionLaboralDto {


    private Integer clienteID;
    private String nitEmpresa;
    private String nombreEmpresa;
    private String direccion;
    private String telefono;
    private String cargo;
    private Date fechaVinculacion;

    public InformacionLaboralDto(Integer clienteID, String nitEmpresa, String nombreEmpresa, String direccion, String telefono, String cargo, Date fechaVinculacion) {
        this.clienteID = clienteID;
        this.nitEmpresa = nitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cargo = cargo;
        this.fechaVinculacion = fechaVinculacion;
    }

    // Getters y setters


    public Integer getClienteID() {
        return clienteID;
    }

    public void setClienteID(Integer clienteID) {
        this.clienteID = clienteID;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }



}
