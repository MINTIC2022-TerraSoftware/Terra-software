package com.mintic.terra_software.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String nombreEmpleado;
    private String correoEmpleado;
    private String rolEmpleado;

    private String username;

    private String password;

    private Integer estatus;

    private Date fechaRegistro;

    @JsonBackReference
    @ManyToOne
    private Empresa idEmpresa;

    @JsonManagedReference(value = "empleado-movimientoDinero")
    @OneToMany(mappedBy = "idEmpleado", orphanRemoval = true)
    private List<MovimientoDinero> listaMovimientosEmpleado;

    // Relacion ManyToMany (Un usuario tiene muchos perfiles)
    // Por defecto Fetch es FetchType.LAZY
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UsuarioPerfil", // tabla intermedia
            joinColumns = @JoinColumn(name = "idUsuario"), // foreignKey en la tabla de UsuarioPerfil
            inverseJoinColumns = @JoinColumn(name = "idPerfil") // foreignKey en la tabla de UsuarioPerfil
    )
    private List<Perfil> perfiles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Empleado(String nombreEmpleado, String correoEmpleado, String rolEmpleado, Empresa idEmpresa, List<MovimientoDinero> listaMovimientosEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.idEmpresa = idEmpresa;
        this.listaMovimientosEmpleado = listaMovimientosEmpleado;
    }

    public void agregarPerfil(Perfil tempPerfil) {
        if (perfiles == null) {
            perfiles = new LinkedList<>();
        }
        perfiles.add(tempPerfil);
    }

}
