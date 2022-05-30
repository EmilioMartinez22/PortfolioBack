package arg.programa.emilio.portfolio.seguridad.repositorio;

import arg.programa.emilio.portfolio.seguridad.modelo.Rol;
import arg.programa.emilio.portfolio.seguridad.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
