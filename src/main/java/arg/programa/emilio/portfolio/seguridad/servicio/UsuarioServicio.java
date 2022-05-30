package arg.programa.emilio.portfolio.seguridad.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arg.programa.emilio.portfolio.seguridad.modelo.Usuario;
import arg.programa.emilio.portfolio.seguridad.repositorio.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioServicio {
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
		return usuarioRepositorio.findByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepositorio.existsByNombreUsuario(nombreUsuario);
	}
	public boolean existsByEmail(String email) {
		return usuarioRepositorio.existsByEmail(email);
	}
	public void save(Usuario usuario) {
		usuarioRepositorio.save(usuario);
	}

}

