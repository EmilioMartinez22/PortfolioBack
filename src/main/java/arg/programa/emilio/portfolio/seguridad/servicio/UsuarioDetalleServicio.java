package arg.programa.emilio.portfolio.seguridad.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import arg.programa.emilio.portfolio.seguridad.modelo.Usuario;
import arg.programa.emilio.portfolio.seguridad.modelo.UsuarioPrincipal;

@Service
public class UsuarioDetalleServicio implements UserDetailsService {

    @Autowired
	UsuarioServicio usuarioServicio;
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		Usuario usuario = usuarioServicio.getByNombreUsuario(nombreUsuario).get();
		return UsuarioPrincipal.build(usuario);
	}

}

