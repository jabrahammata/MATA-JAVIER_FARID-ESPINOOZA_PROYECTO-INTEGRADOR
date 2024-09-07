package dh.backend.clinicamvc.controller;

import dh.backend.clinicamvc.entity.Odontologo;
import dh.backend.clinicamvc.exception.BadRequestException;
import dh.backend.clinicamvc.exception.ResourceNotFoundException;
import dh.backend.clinicamvc.impl.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologo")

public class OdontologoController {

    public OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
        public ResponseEntity<Odontologo> registrarOdontologo (@RequestBody Odontologo odontologo) throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(odontologoService.registrarOdontologo(odontologo));
    }

    @GetMapping("/{id}")
        public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){
        Optional<Odontologo> odontologo = odontologoService.buscarOdontologoPorId(id);
        if (odontologo.isPresent()) {
            Odontologo odontologoARetornar = odontologo.get();
            return ResponseEntity.ok(odontologoARetornar);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }

    @GetMapping
        public ResponseEntity<List<Odontologo>> listarTodos(){
            return ResponseEntity.ok(odontologoService.listarOdontologos());
        }

    @PutMapping
        public ResponseEntity<String> actualizarOdontologo(@RequestBody Odontologo odontologo){
            Optional<Odontologo> odontologoOptional = odontologoService.buscarOdontologoPorId(odontologo.getId());
            if (odontologoOptional.isPresent()) {
                odontologoService.actualizarOdontologo(odontologo);
                return ResponseEntity.ok("{\"message\": \"odontólogo actualizado\"}");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"odontólogo no encontrado\"}");
            }
        }

    @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminarOdontologo(@PathVariable Integer id) throws ResourceNotFoundException {
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("{\"message\": \"odontólogo eliminado\"}");
        }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<Odontologo>> buscarPorApellido(@PathVariable String apellido){
        List<Odontologo> listaOdontologos =odontologoService.buscarPorApellido(apellido);
        if(listaOdontologos.size()>0){
            return ResponseEntity.ok(listaOdontologos);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
