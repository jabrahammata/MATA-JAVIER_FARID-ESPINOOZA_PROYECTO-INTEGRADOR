package com.dh.Clinica.controller;

import com.dh.Clinica.entity.Paciente;
import com.dh.Clinica.service.impl.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VistaController {
    private PacienteService pacienteService;

    public VistaController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/index")
    public String buscarPaciente(Model model, @RequestParam Integer id) {
        Paciente paciente = pacienteService.buscarPorId(id).get();
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "vista/paciente";
    }
}
