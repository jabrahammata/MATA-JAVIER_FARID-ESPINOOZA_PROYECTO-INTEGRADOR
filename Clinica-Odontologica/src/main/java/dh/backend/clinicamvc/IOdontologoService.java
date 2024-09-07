package dh.backend.clinicamvc;

import dh.backend.clinicamvc.entity.Odontologo;
import dh.backend.clinicamvc.entity.Paciente;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo registrarOdontologo(Odontologo odontologo) throws BadRequestException;

    List<Odontologo> listarOdontologos();

    Optional<Odontologo> buscarOdontologoPorId(Integer id);

    void actualizarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Integer id) throws ResourceNotFoundException;

    List<Odontologo> buscarPorApellido(String apellido);
}
