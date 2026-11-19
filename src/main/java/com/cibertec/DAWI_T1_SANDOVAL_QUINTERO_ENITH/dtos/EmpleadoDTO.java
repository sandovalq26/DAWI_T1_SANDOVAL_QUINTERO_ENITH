package com.cibertec.DAWI_T1_SANDOVAL_QUINTERO_ENITH.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String especialidad;
}
