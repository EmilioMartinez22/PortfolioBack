package arg.programa.emilio.portfolio.seguridad.servicio;

import arg.programa.emilio.portfolio.seguridad.modelo.Rol;
import arg.programa.emilio.portfolio.seguridad.enums.RolNombre;
import arg.programa.emilio.portfolio.seguridad.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolServicio {

    @Autowired
    RolRepositorio rolRepositorio;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepositorio.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepositorio.save(rol);
    }
}
