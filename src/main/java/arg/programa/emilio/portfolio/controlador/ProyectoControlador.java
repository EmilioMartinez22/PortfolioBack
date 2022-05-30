package arg.programa.emilio.portfolio.controlador;

import arg.programa.emilio.portfolio.dto.Mensaje;
import arg.programa.emilio.portfolio.dto.ProyectoDto;
import arg.programa.emilio.portfolio.modelo.Proyecto;
import arg.programa.emilio.portfolio.servicio.ProyectoServicio;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoControlador {

    @Autowired
    ProyectoServicio proyectoServicio;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proyectoServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyectoServicio.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @GetMapping("/detailname/{institucion}")
    public ResponseEntity<Proyecto> getByNombre(@PathVariable("nombre") String institucion){
        if(!proyectoServicio.existsByInstitucion(institucion))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyectoServicio.getByInstitucion(institucion).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")	
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto){
      
        Proyecto proyecto = new Proyecto(proyectoDto.getInstitucion(), proyectoDto.getDescripcion(),
        		proyectoDto.getImagenUrl(),proyectoDto.getAnio());
        proyectoServicio.save(proyecto);
        return new ResponseEntity(new Mensaje("proyecto guardado"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProyectoDto proyectoDto){
        
        Proyecto proyecto = proyectoServicio.getOne(id).get();
        proyecto.setInstitucion(proyectoDto.getInstitucion());
        proyecto.setDescripcion(proyectoDto.getDescripcion());
        proyecto.setImagenUrl(proyectoDto.getImagenUrl());
    	proyecto.setAnio(proyectoDto.getAnio());
        proyectoServicio.save(proyecto);
        return new ResponseEntity(new Mensaje("proyecto actualizado"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyectoServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        proyectoServicio.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }


}
