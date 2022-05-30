package arg.programa.emilio.portfolio.seguridad.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import arg.programa.emilio.portfolio.seguridad.servicio.UsuarioDetalleServicio;

public class JwtFiltro extends OncePerRequestFilter{

	private final static Logger logger = LoggerFactory.getLogger(JwtFiltro.class);
	
	@Autowired
	JwtProveedor jwtProveedor;
	@Autowired
	UsuarioDetalleServicio usuarioDetalleServicio;
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = getToken(req);
			if(token != null && jwtProveedor.validateToken(token)) {
				String nombreUsuario = jwtProveedor.getNombreUsuarioFromToken(token);
				UserDetails userDetails = usuarioDetalleServicio.loadUserByUsername(nombreUsuario);
				UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}catch (Exception e) {
			logger.error("fail en el método doFilter");
		}
		filterChain.doFilter(req, res);
		
	}
	
	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if(header != null && header.startsWith("Bearer"))
			return header.replace("Bearer", "");
		return null;
	}
	

}

