package com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.services;

import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.dtos.EmpleadoDTO;
import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.dtos.EmpleadoRequestDTO;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoDTO> listarTodos();

    EmpleadoDTO obtenerPorId(Integer id);

    EmpleadoDTO registrar(EmpleadoRequestDTO request);

    EmpleadoDTO actualizar(Integer id, EmpleadoRequestDTO request);

    void eliminar(Integer id);
}
