package com.mintic.terra_software.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String nombreEmpleado;
    private String correoEmpleado;
    private EnumRol rolEmpleado;

    private EnumRol estado;

    private String password;

    @JsonBackReference
    @ManyToOne()
    private Empresa idEmpresa;

    @JsonManagedReference(value = "empleado-movimientoDinero")
    @OneToMany(mappedBy = "idEmpleado", orphanRemoval = true)
    private List<MovimientoDinero> listaMovimientosEmpleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado() {
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public EnumRol getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(EnumRol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public List<MovimientoDinero> getListaMovimientosEmpleado() {
        return listaMovimientosEmpleado;
    }

    public void setListaMovimientosEmpleado(List<MovimientoDinero> listaMovimientosEmpleado) {
        this.listaMovimientosEmpleado = listaMovimientosEmpleado;
    }

    public Empleado(String nombreEmpleado, String correoEmpleado, String nombreEmpresaEmpleado, EnumRol rolEmpleado, Empresa idEmpresa) {
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.idEmpresa= idEmpresa;
        this.listaMovimientosEmpleado = listaMovimientosEmpleado;
    }


}
