package com.mintic.terra_software.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name="empresas")
public class Empresa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String nit;

    @JsonManagedReference
    @OneToMany(mappedBy = "idEmpresa", orphanRemoval = true)
    private List<Empleado> listaEmpleados;

    @JsonManagedReference
    @OneToMany(mappedBy = "idEmpresa", orphanRemoval = true)
    private List<MovimientoDinero> listaMovimientosDinero;


    public Empresa(String nombre, String direccion, String telefono, String nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa)) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(getNombre(), empresa.getNombre()) && Objects.equals(getDireccion(), empresa.getDireccion()) && Objects.equals(getTelefono(), empresa.getTelefono()) && Objects.equals(getNit(), empresa.getNit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getDireccion(), getTelefono(), getNit());
    }

    public Empresa() {

    }

}
