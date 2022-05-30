package arg.programa.emilio.portfolio.controlador;

import arg.programa.emilio.portfolio.dto.Mensaje;
import arg.programa.emilio.portfolio.dto.PersonaDto;
import arg.programa.emilio.portfolio.modelo.Persona;
import arg.programa.emilio.portfolio.servicio.PersonaServicio;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaControlador {
	
	@Autowired
    PersonaServicio personaServicio;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaServicio.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Persona> getByNombre(@PathVariable("nombre") String nombre){
        if(!personaServicio.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaServicio.getByNombre(nombre).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")	
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("Descripcion es campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getImagenUrl()))
            return new ResponseEntity(new Mensaje("Imagen es campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getEmail()))
            return new ResponseEntity(new Mensaje("E"), HttpStatus.BAD_REQUEST);
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getDescripcion(),personaDto.getImagenUrl(),
        		personaDto.getEmail(),personaDto.getTelefono());
        personaServicio.save(persona);
        return new ResponseEntity(new Mensaje("persona creada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody PersonaDto personaDto){
        if(!personaServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(personaServicio.existsByNombre(personaDto.getNombre()) && personaServicio.getByNombre(personaDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getDescripcion()))
            return new ResponseEntity(new Mensaje("Descripcion es campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getImagenUrl()))
            return new ResponseEntity(new Mensaje("Imagen es campo obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getEmail()))
            return new ResponseEntity(new Mensaje("E"), HttpStatus.BAD_REQUEST);

        Persona persona = personaServicio.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setImagenUrl(personaDto.getImagenUrl());
        persona.setDescripcion(personaDto.getDescripcion());
        persona.setEmail(personaDto.getEmail());
        persona.setTelefono(personaDto.getTelefono());
        personaServicio.save(persona);
        return new ResponseEntity(new Mensaje("persona actualizada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        personaServicio.delete(id);
        return new ResponseEntity(new Mensaje("persona borrada"), HttpStatus.OK);
    }

}

