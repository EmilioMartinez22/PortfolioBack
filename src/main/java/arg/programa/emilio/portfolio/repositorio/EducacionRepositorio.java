package arg.programa.emilio.portfolio.repositorio;

import arg.programa.emilio.portfolio.modelo.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducacionRepositorio extends JpaRepository<Educacion, Integer> {
    Optional<Educacion> findByInstitucion(String institucion);
    boolean existsByInstitucion(String institucion);
}
