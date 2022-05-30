package arg.programa.emilio.portfolio.servicio;

import arg.programa.emilio.portfolio.modelo.Persona;
import arg.programa.emilio.portfolio.repositorio.PersonaRepositorio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PersonaServicio {
	
	@Autowired
    PersonaRepositorio personaRepositorio;

    public List<Persona> list(){
        return personaRepositorio.findAll();
    }

    public Optional<Persona> getOne(int id){
        return personaRepositorio.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre){
        return personaRepositorio.findByNombre(nombre);
    }

    public void  save(Persona persona){
        personaRepositorio.save(persona);
    }

    public void delete(int id){
        personaRepositorio.deleteById(id);
    }

    public boolean existsById(int id){
        return personaRepositorio.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return personaRepositorio.existsByNombre(nombre);
    }


}
