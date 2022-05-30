package arg.programa.emilio.portfolio.dto;

public class PersonaDto {

	private String nombre;
	private String imagenUrl;
	private String descripcion;
	private String email;
	private int telefono;
	
	public PersonaDto() {
		
	}

	public PersonaDto(String nombre, String imagenUrl, String descripcion, String email,int telefono) {
		super();
		this.nombre = nombre;
		this.imagenUrl = imagenUrl;
		this.descripcion = descripcion;
		this.email = email;
		this.telefono = telefono;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}	
	
}
