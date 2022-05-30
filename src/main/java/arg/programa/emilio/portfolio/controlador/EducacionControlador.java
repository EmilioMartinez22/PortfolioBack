package arg.programa.emilio.portfolio.controlador;

import arg.programa.emilio.portfolio.dto.Mensaje;
import arg.programa.emilio.portfolio.dto.EducacionDto;
import arg.programa.emilio.portfolio.modelo.Educacion;
import arg.programa.emilio.portfolio.servicio.EducacionServicio;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionControlador {

    @Autowired
    EducacionServicio educacionServicio;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!educacionServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionServicio.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @GetMapping("/detailname/{institucion}")
    public ResponseEntity<Educacion> getByNombre(@PathVariable("institucion") String institucion){
        if(!educacionServicio.existsByInstitucion(institucion))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionServicio.getByInstitucion(institucion).get();
        return new ResponseEntity(institucion, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")	
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){
        if(StringUtils.isBlank(educacionDto.getInstitucion()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(educacionDto.getEntrada()<0 )
            return new ResponseEntity(new Mensaje("el año debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(educacionServicio.existsByInstitucion(educacionDto.getInstitucion()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Educacion educacion = new Educacion(educacionDto.getInstitucion(),educacionDto.getDescripcion(),educacionDto.getImagenUrl(),
        		educacionDto.getEntrada(),educacionDto.getSalida());
        educacionServicio.save(educacion);
        return new ResponseEntity(new Mensaje( "guardado"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EducacionDto educacionDto){
        if(!educacionServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(educacionServicio.existsByInstitucion(educacionDto.getInstitucion()) && educacionServicio.getByInstitucion(educacionDto.getInstitucion()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educacionDto.getInstitucion()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(educacionDto.getEntrada()<0 )
            return new ResponseEntity(new Mensaje("el año de ingreso debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = educacionServicio.getOne(id).get();
        educacion.setInstitucion(educacionDto.getInstitucion());
        educacion.setImagenUrl(educacionDto.getImagenUrl());
        educacion.setDescripcion(educacionDto.getDescripcion());
        educacion.setEntrada(educacionDto.getEntrada());
        educacion.setSalida(educacionDto.getSalida());
        educacionServicio.save(educacion);

        return new ResponseEntity(new Mensaje("Actualizado"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!educacionServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        educacionServicio.delete(id);
        return new ResponseEntity(new Mensaje("Eliminado"), HttpStatus.OK);
    }


}
