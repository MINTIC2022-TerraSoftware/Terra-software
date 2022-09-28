package com.mintic.terra_software.repository;

import com.mintic.terra_software.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository <Empleado, Long> {
}
