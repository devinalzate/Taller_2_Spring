package co.edu.udistrital.taller2.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoModel {
    private String correo;
    private String telofono;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
}
