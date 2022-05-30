package arg.programa.emilio.portfolio.repositorio;

import arg.programa.emilio.portfolio.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
	
	Optional<Persona> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
