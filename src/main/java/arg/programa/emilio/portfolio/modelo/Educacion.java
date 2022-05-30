package arg.programa.emilio.portfolio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institucion;
    private String descripcion;
    private String imagenUrl;
    private int entrada;
    private int salida;
    
    
    
    public Educacion() {
		
	}

	public Educacion(String institucion, String descripcion, String imagenUrl, int entrada, int salida) {
    	
    	this.institucion = institucion;
		this.descripcion = descripcion;
		this.imagenUrl = imagenUrl;
		this.entrada = entrada;
		this.salida = salida;
	}







	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
