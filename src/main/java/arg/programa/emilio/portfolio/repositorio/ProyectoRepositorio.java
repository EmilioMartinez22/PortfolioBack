package arg.programa.emilio.portfolio.repositorio;

import arg.programa.emilio.portfolio.modelo.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProyectoRepositorio extends JpaRepository<Proyecto, Integer> {
    Optional<Proyecto> findByInstitucion(String institucion);
	boolean existsByInstitucion(String institucion);
}