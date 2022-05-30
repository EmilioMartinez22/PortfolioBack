package arg.programa.emilio.portfolio.servicio;

import arg.programa.emilio.portfolio.modelo.Experiencia;
import arg.programa.emilio.portfolio.repositorio.ExperienciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienciaServicio {

    @Autowired
    ExperienciaRepositorio experienciaRepositorio;

    public List<Experiencia> list(){
        return experienciaRepositorio.findAll();
    }

    public Optional<Experiencia> getOne(int id){
        return experienciaRepositorio.findById(id);
    }

    public Optional<Experiencia> getByEmpresa(String empresa){
        return experienciaRepositorio.findByEmpresa(empresa);
    }

    public void  save(Experiencia experiencia){
        experienciaRepositorio.save(experiencia);
    }

    public void delete(int id){
        experienciaRepositorio.deleteById(id);
    }

    public boolean existsById(int id){
        return experienciaRepositorio.existsById(id);
    }

    public boolean existsByEmpresa(String empresa){
        return experienciaRepositorio.existsByEmpresa(empresa);
    }
}

