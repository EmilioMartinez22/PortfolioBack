package arg.programa.emilio.portfolio.servicio;

import arg.programa.emilio.portfolio.modelo.Skill;
import arg.programa.emilio.portfolio.repositorio.SkillRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillServicio {

    @Autowired
    SkillRepositorio skillRepositorio;

    public List<Skill> list(){
        return skillRepositorio.findAll();
    }

    public Optional<Skill> getOne(int id){
        return skillRepositorio.findById(id);
    }

    public Optional<Skill> getByNombre(String nombre){
        return skillRepositorio.findByNombre(nombre);
    }

    public void  save(Skill skill){
        skillRepositorio.save(skill);
    }

    public void delete(int id){
        skillRepositorio.deleteById(id);
    }

    public boolean existsById(int id){
        return skillRepositorio.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return skillRepositorio.existsByNombre(nombre);
    }
}
