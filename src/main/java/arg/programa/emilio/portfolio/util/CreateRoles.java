/*package arg.programa.emilio.portfolio.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import arg.programa.emilio.portfolio.seguridad.modelo.Rol;
import arg.programa.emilio.portfolio.seguridad.enums.RolNombre;
import arg.programa.emilio.portfolio.seguridad.servicio.RolServicio;

@Component
public class CreateRoles implements CommandLineRunner {

	@Autowired
	RolServicio rolServicio;
	
	@Override
	public void run(String... args) throws Exception {
		Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUser = new Rol(RolNombre.ROLE_USER);
		rolServicio.save(rolAdmin);
		rolServicio.save(rolUser);
		
		
	}

}*/
