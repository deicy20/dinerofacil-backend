package com.dinerofacil.backend.model;
import jakarta.persistence.*;



@Entity
public class Referencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer referenciaID;

    @ManyToOne
    @JoinColumn(name = "clienteID")
    private Cliente cliente;

    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String email;
    private String tipoReferencia;
    private String parentesco;

    // Getters y setters

    public Integer getReferenciaID() {
        return referenciaID;
    }

    public void setReferenciaID(Integer referenciaID) {
        this.referenciaID = referenciaID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoReferencia() {
        return tipoReferencia;
    }

    public void setTipoReferencia(String tipoReferencia) {
        this.tipoReferencia = tipoReferencia;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
