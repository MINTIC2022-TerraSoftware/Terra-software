package com.mintic.terra_software.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "movimientos")
public class MovimientoDinero {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double monto;
    private String concepto;

<<<<<<< HEAD
    /*@ManyToOne
    @JoinColumn(name="id_empresa")*/
    //private Empresa idEmpresa;

    /*@ManyToOne
    @JoinColumn(name="id_empleado")*/
    //private Empleado idEmpleado;
=======
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="idEmpresa")
    private Empresa idEmpresa;


    @JsonBackReference(value = "empleado-movimientoDinero")
    @ManyToOne
    @JoinColumn(name="idEmpleado")
    private Empleado idEmpleado;
>>>>>>> d0ff8f5 (Relacion de Entidades, codigo funcionando)


    public MovimientoDinero() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

<<<<<<< HEAD
=======
    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
>>>>>>> d0ff8f5 (Relacion de Entidades, codigo funcionando)
}
