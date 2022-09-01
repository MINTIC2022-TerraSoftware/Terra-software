package com.mintic.terra_software.repository;

import com.mintic.terra_software.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository <Empresa, Long> {
}
