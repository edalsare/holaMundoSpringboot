
package com.coltis.holaMundoSpring.dao;

import com.coltis.holaMundoSpring.domain.Persona;
import org.springframework.data.repository.CrudRepository;


public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
