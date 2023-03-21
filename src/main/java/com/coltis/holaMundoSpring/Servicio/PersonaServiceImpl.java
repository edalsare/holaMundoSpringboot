
package com.coltis.holaMundoSpring.Servicio;

import com.coltis.holaMundoSpring.dao.PersonaDao;
import com.coltis.holaMundoSpring.domain.Persona;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private PersonaDao PersonaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listaPersonas() {
       return (List<Persona>) PersonaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        PersonaDao.save(persona);
        }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        PersonaDao.delete(persona);
        }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return PersonaDao.findById(persona.getIdPersona()).orElse(null);
        }
    
}
