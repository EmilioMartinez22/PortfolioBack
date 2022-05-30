package arg.programa.emilio.portfolio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institucion;
    private String descripcion;
    private String imagenUrl;
    private int anio;
    
    public Proyecto() {
    	
    }
    
	public Proyecto(String institucion, String descripcion, String imagenUrl, int anio) {
		this.institucion = institucion;
		this.descripcion = descripcion;
		this.imagenUrl = imagenUrl;
		this.anio = anio;
		
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


	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	   
    
}
