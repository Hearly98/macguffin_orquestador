package com.macguffin.orquestador.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RegisterDTO {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String fechaNacimiento;
    private String telefono;
    private String rolesName;
}
