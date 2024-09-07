package dh.backend.clinicamvc.impl;

import dh.backend.clinicamvc.entity.Odontologo;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;
import dh.backend.clinicamvc.repository.IOdontologoRepository;
import dh.backend.clinicamvc.IOdontologoService;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    private static Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);

    private IOdontologoRepository odontologoRepository;

    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo registrarOdontologo(Odontologo odontologo) throws BadRequestException {
        if(StringUtils.isEmpty(odontologo.getNombre()) || StringUtils.isEmpty(odontologo.getApellido()) || StringUtils.isEmpty(odontologo.getMatricula())){
        LOGGER.error("Error al crear odontólogo, contiene campos vacios");
        throw new BadRequestException("{\"message\": \"El Odontólogo no puede tener campos vacios}");
    }
        LOGGER.info("Odontólogo registrado en base de datos: "+ odontologo);
        return odontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> listarOdontologos(){
        LOGGER.info("Listando Odontólogos");
        return odontologoRepository.findAll();
    }

        @Override
    public void actualizarOdontologo(Odontologo odontologo) {
        LOGGER.info("Actualizando odontólogo "+ odontologo);
        odontologoRepository.save(odontologo);}

    @Override
    public void eliminarOdontologo(Integer id) throws ResourceNotFoundException {
    Optional<Odontologo> odontologoOptional = buscarOdontologoPorId(id);
    if (odontologoOptional.isPresent()){
        LOGGER.info("Odontólogo eliminado con id "+ id);
        odontologoRepository.deleteById(id);
    }
    else throw new ResourceNotFoundException("{\"message\": \"odontologo no encontrado\"}");
    }

    @Override
        public List<Odontologo> buscarPorApellido(String apellido) {
        LOGGER.info("Búsqueda de odontólogo por apellido "+ apellido);
        return odontologoRepository.buscarPorApellido(apellido);
    }

}
