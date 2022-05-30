package arg.programa.emilio.portfolio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String empresa;
    private String descripcion;
    private String imagenUrl;
    private int entrada;
    private int salida;
    
	public Experiencia() {
	}



	public Experiencia(String empresa2, String descripcion2, String imagenUrl2, int entrada2, int salida2) {
		this.empresa = empresa2;
		this.descripcion = descripcion2;
		this.imagenUrl = imagenUrl2;
		this.entrada = entrada2;
		this.salida = salida2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

