package arg.programa.emilio.portfolio.dto;

public class ExperienciaDto {
	
	
	private String empresa;
    private String descripcion;
    private String imagenUrl;
    private int entrada;
    private int salida;
    
    
    
    
	public ExperienciaDto() {
	
	}
	public ExperienciaDto(String empresa, String descripcion, String imagenUrl, int entrada, int salida) {
		super();
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.imagenUrl = imagenUrl;
		this.entrada = entrada;
		this.salida = salida;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
	public int getEntrada() {
		return entrada;
	}
	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}
	public int getSalida() {
		return salida;
	}
	public void setSalida(int salida) {
		this.salida = salida;
	}
    
    
	
}
