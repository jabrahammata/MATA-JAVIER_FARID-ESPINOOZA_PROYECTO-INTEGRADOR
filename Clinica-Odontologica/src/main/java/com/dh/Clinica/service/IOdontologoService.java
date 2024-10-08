package com.dh.Clinica.service;

import com.dh.Clinica.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);

    Optional<Odontologo> buscarPorId(Integer id);
    List<Odontologo> buscarTodos();

    void modificarOdontologo(Odontologo odontologo);

    void eliminarOdontologo(Integer id);

    List<Odontologo> buscarPorNombre(String nombre);

    List<Odontologo> buscarPorApellido(String apellido);

    List<Odontologo>  ordenarPorApellido();
}
