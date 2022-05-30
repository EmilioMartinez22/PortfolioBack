package arg.programa.emilio.portfolio.servicio;

import arg.programa.emilio.portfolio.modelo.Educacion;
import arg.programa.emilio.portfolio.repositorio.EducacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducacionServicio {

    @Autowired
    EducacionRepositorio educacionRepositorio;

    public List<Educacion> list(){
        return educacionRepositorio.findAll();
    }

    public Optional<Educacion> getOne(int id){
        return educacionRepositorio.findById(id);
    }

    public Optional<Educacion> getByInstitucion(String institucion){
        return educacionRepositorio.findByInstitucion(institucion);
    }

    public void  save(Educacion educacion){
        educacionRepositorio.save(educacion);
    }

    public void delete(int id){
        educacionRepositorio.deleteById(id);
    }

    public boolean existsById(int id){
        return educacionRepositorio.existsById(id);
    }

    public boolean existsByInstitucion(String institucion){
        return educacionRepositorio.existsByInstitucion(institucion);
    }
}
/* test push origin*/