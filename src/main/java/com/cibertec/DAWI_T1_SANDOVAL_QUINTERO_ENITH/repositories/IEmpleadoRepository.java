package com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.repositories;

import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {
}
