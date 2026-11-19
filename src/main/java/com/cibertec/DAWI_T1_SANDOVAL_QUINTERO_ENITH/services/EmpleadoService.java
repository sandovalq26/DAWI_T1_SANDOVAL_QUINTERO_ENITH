package com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.services;

import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.dtos.EmpleadoDTO;
import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.dtos.EmpleadoRequestDTO;
import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.entity.EmpleadoEntity;
import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.exceptions.RecursoNoEncontradoException;
import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.repositories.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService implements IEmpleadoService {

    private final IEmpleadoRepository iEmpleadoRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<EmpleadoDTO> listarTodos() {
        return iEmpleadoRepository.findAll()
                .stream()
                .map(empleado -> objectMapper.convertValue(empleado, EmpleadoDTO.class))
                .toList();
    }

    @Override
    public EmpleadoDTO obtenerPorId(Integer id) {
        EmpleadoEntity empleado = iEmpleadoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Empleado no encontrado con id: " + id));
        return objectMapper.convertValue(empleado, EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO registrar(EmpleadoRequestDTO request) {
        EmpleadoEntity entidad = objectMapper.convertValue(request, EmpleadoEntity.class);
        entidad.setId(null);
        EmpleadoEntity guardado = iEmpleadoRepository.save(entidad);
        return objectMapper.convertValue(guardado, EmpleadoDTO.class);
    }

    @Override
    public EmpleadoDTO actualizar(Integer id, EmpleadoRequestDTO request) {
        EmpleadoEntity existente = iEmpleadoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Empleado no encontrado con id: " + id));

        existente.setNombre(request.getNombre());
        existente.setApellido(request.getApellido());
        existente.setEmail(request.getEmail());
        existente.setEspecialidad(request.getEspecialidad());

        EmpleadoEntity actualizado = iEmpleadoRepository.save(existente);
        return objectMapper.convertValue(actualizado, EmpleadoDTO.class);
    }

    @Override
    public void eliminar(Integer id) {
        if (!iEmpleadoRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Empleado no encontrado con id: " + id);
        }
        iEmpleadoRepository.deleteById(id);
    }
}
