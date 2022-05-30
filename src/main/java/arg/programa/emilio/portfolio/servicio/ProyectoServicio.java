package arg.programa.emilio.portfolio.servicio;

import arg.programa.emilio.portfolio.modelo.Proyecto;
import arg.programa.emilio.portfolio.repositorio.ProyectoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProyectoServicio {

    @Autowired
    ProyectoRepositorio proyectoRepositorio;

    public List<Proyecto> list(){
        return proyectoRepositorio.findAll();
    }

    public Optional<Proyecto> getOne(int id){
        return proyectoRepositorio.findById(id);
    }

    public Optional<Proyecto> getByInstitucion(String institucion){
        return  proyectoRepositorio.findByInstitucion(institucion);
    }

    public void  save(Proyecto proyecto){
        proyectoRepositorio.save(proyecto);
    }

    public void delete(int id){
        proyectoRepositorio.deleteById(id);
    }

    public boolean existsById(int id){
        return proyectoRepositorio.existsById(id);
    }

    public boolean existsByInstitucion(String institucion){
        return proyectoRepositorio.existsByInstitucion(institucion);
    }
}
