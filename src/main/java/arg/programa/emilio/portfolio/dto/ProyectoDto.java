package arg.programa.emilio.portfolio.dto;

public class ProyectoDto {
	
    private String institucion;
    private String descripcion;
    private String imagenUrl;
    private int anio;
    
    
    
	public ProyectoDto() {
		
	}



	public ProyectoDto(String institucion, String descripcion, String imagenUrl, int anio) {
		super();
		this.institucion = institucion;
		this.descripcion = descripcion;
		this.imagenUrl = imagenUrl;
		this.anio = anio;
	}



	public String getInstitucion() {
		return institucion;
	}



	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getImagenUrl() {
		return imagenUrl;
	}



	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}



	public int getAnio() {
		return anio;
	}



	public void setAnio(int anio) {
		this.anio = anio;
	}
    
	
    

}
