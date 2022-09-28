package com.mintic.terra_software.service;

import com.mintic.terra_software.model.Empleado;

import java.util.List;

public interface IUsuariosService {
	void guardar(Empleado usuario);
	void eliminar(Integer idUsuario);
	List<Empleado> buscarTodos();
	List<Empleado> buscarRegistrados();
	Empleado buscarPorId(Integer idUsuario);
	Empleado buscarPorUsername(String username);
	int bloquear(int idUsuario);
	int activar(int idUsuario);
}
