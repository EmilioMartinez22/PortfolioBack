package arg.programa.emilio.portfolio.seguridad.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arg.programa.emilio.portfolio.seguridad.modelo.Usuario;

@Repository
public interface UsuarioRepositorio  extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	boolean existsByNombreUsuario(String nombreUsuario);
	boolean existsByEmail(String email);
	
}