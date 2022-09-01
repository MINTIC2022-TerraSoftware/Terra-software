package com.mintic.terra_software.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name="empresa")
public class Empresa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String nit;


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
