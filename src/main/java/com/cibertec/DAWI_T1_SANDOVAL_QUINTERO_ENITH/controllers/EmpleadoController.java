package com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.controllers;

import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.dtos.EmpleadoDTO;
import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.dtos.EmpleadoRequestDTO;
import com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.services.IEmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService iEmpleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> listarEmpleados() {
        return ResponseEntity.ok(iEmpleadoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> buscarEmpleado(@PathVariable Integer id) {
        return ResponseEntity.ok(iEmpleadoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<EmpleadoDTO> registrarEmpleado(@Valid @RequestBody EmpleadoRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iEmpleadoService.registrar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(
            @PathVariable Integer id,
            @Valid @RequestBody EmpleadoRequestDTO request) {
        return ResponseEntity.ok(iEmpleadoService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id) {
        iEmpleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
