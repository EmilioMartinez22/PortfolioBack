package arg.programa.emilio.portfolio.controlador;

import arg.programa.emilio.portfolio.dto.Mensaje;
import arg.programa.emilio.portfolio.dto.ExperienciaDto;
import arg.programa.emilio.portfolio.modelo.Experiencia;
import arg.programa.emilio.portfolio.servicio.ExperienciaServicio;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaControlador {

    @Autowired
    ExperienciaServicio experienciaServicio;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!experienciaServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaServicio.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @GetMapping("/detailname/{empresa}")
    public ResponseEntity<Experiencia> getByEmpresa(@PathVariable("empresa") String empresa){
        if(!experienciaServicio.existsByEmpresa(empresa))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaServicio.getByEmpresa(empresa).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")	
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto){

    	Experiencia experiencia = new Experiencia(experienciaDto.getEmpresa(),experienciaDto.getDescripcion(),
    			experienciaDto.getImagenUrl(),experienciaDto.getEntrada(),experienciaDto.getSalida());
    	experienciaServicio.save(experiencia);
        return new ResponseEntity(new Mensaje("Creada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ExperienciaDto experienciaDto){
    	Experiencia experiencia = experienciaServicio.getOne(id).get();
    	experiencia.setEmpresa(experienciaDto.getEmpresa());
    	experiencia.setDescripcion(experienciaDto.getDescripcion());
    	experiencia.setImagenUrl(experienciaDto.getImagenUrl());
    	experiencia.setEntrada(experienciaDto.getEntrada());
    	experiencia.setSalida(experienciaDto.getSalida());
    	experienciaServicio.save(experiencia);

        return new ResponseEntity(new Mensaje("Actualizado"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!experienciaServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        experienciaServicio.delete(id);
        return new ResponseEntity(new Mensaje("Eliminada"), HttpStatus.OK);
    }


}
