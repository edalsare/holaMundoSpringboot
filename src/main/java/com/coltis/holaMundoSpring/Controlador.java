
package com.coltis.holaMundoSpring;

import com.coltis.holaMundoSpring.Servicio.PersonaService;
import com.coltis.holaMundoSpring.dao.PersonaDao;
import com.coltis.holaMundoSpring.domain.Persona;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class Controlador {
    
    @Autowired
    private PersonaService PersonaService;
    @GetMapping("/")
    
    public String inicio(Model model){
        var personas = PersonaService.listaPersonas();
        model.addAttribute("personas", personas);
        
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona ,Model model) {
        persona = PersonaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona personal) {
        PersonaService.eliminar(personal);
        return "redirect:/";
    }  
    
    @PostMapping("/guardar")
    public String guardar(Persona persona) {
        PersonaService.guardar(persona);
        return "redirect:/";
    }
}
