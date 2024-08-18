package cl.praxis.hospital_post_pandemia.controller;

import cl.praxis.hospital_post_pandemia.model.Paciente;
import cl.praxis.hospital_post_pandemia.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/pacientes")
    public String listarPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        model.addAttribute("pacientes", pacientes);
        return "pacientes";
    }

    @GetMapping("/pacientes/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "registrar_paciente";
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.guardarPaciente(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        model.addAttribute("paciente", paciente);
        return "editar_paciente";
    }

    @PostMapping("/pacientes/actualizar/{id}")
    public String actualizarPaciente(@PathVariable Long id, @ModelAttribute Paciente pacienteActualizado) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        paciente.setNombre(pacienteActualizado.getNombre());
        paciente.setApellido(pacienteActualizado.getApellido());
        paciente.setDiagnostico(pacienteActualizado.getDiagnostico());
        paciente.setHabitacion(pacienteActualizado.getHabitacion());
        pacienteService.guardarPaciente(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/eliminar/{id}")
    public String eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return "redirect:/pacientes";
    }

    @GetMapping("/pacientes/{id}")
    public String verPaciente(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        model.addAttribute("paciente", paciente);
        return "ver_paciente";
    }
}
