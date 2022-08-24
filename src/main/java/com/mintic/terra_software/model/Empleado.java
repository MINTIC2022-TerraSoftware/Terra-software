package com.mintic.terra_software.model;

public class Empleado {


    private String nombreEmpleado;
    private String correoEmpleado;
    private String nombreEmpresaEmpleado;
    private String rolEmpleado;

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

    public String getNombreEmpresaEmpleado() {
        return nombreEmpresaEmpleado;
    }

    public void setNombreEmpresaEmpleado(String nombreEmpresaEmpleado) {
        this.nombreEmpresaEmpleado = nombreEmpresaEmpleado;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Empleado(String nombreEmpleado, String correoEmpleado, String nombreEmpresaEmpleado, String rolEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.nombreEmpresaEmpleado = nombreEmpresaEmpleado;
        this.rolEmpleado = rolEmpleado;
    }


}
