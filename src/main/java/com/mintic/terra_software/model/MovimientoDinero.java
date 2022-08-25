package com.mintic.terra_software.model;

public class MovimientoDinero {
    private float Monto;
    private String concepto;
    private String Usuario;

    public MovimientoDinero(float monto, String concepto, String usuario) {
        Monto = monto;
        this.concepto = concepto;
        Usuario = usuario;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float monto) {
        Monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
}
