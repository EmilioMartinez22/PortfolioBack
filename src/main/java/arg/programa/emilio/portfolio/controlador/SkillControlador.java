package arg.programa.emilio.portfolio.controlador;

import arg.programa.emilio.portfolio.dto.Mensaje;
import arg.programa.emilio.portfolio.dto.SkillDto;
import arg.programa.emilio.portfolio.modelo.Skill;
import arg.programa.emilio.portfolio.servicio.SkillServicio;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillControlador {

    @Autowired
    SkillServicio skillServicio;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = skillServicio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!skillServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillServicio.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @GetMapping("/detailname/{nombre}")
    public ResponseEntity<Skill> getByNombre(@PathVariable("nombre") String nombre){
        if(!skillServicio.existsByNombre(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillServicio.getByNombre(nombre).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")	
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto){
        if(StringUtils.isBlank(skillDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillDto.getPorcentaje()<0 )
            return new ResponseEntity(new Mensaje("el valor del habilidad debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(skillServicio.existsByNombre(skillDto.getNombre()))
            return new ResponseEntity(new Mensaje("esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(skillDto.getNombre(), skillDto.getPorcentaje(),skillDto.getImagenUrl());
        skillServicio.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody SkillDto skillDto){
        if(!skillServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(skillServicio.existsByNombre(skillDto.getNombre()) && skillServicio.getByNombre(skillDto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(skillDto.getNombre()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillDto.getPorcentaje()<0 )
            return new ResponseEntity(new Mensaje("el valor debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        Skill skill = skillServicio.getOne(id).get();
        skill.setNombre(skillDto.getNombre());
        skill.setPorcentaje(skillDto.getPorcentaje());
        skill.setImagenUrl(skillDto.getImagenUrl());
        skillServicio.save(skill);
        return new ResponseEntity(new Mensaje("habilidad actualizada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skillServicio.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        skillServicio.delete(id);
        return new ResponseEntity(new Mensaje("habilidad eliminado"), HttpStatus.OK);
    }


}