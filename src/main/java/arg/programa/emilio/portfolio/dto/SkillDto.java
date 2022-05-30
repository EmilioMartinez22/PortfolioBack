package arg.programa.emilio.portfolio.dto;

public class SkillDto {

	
	
    private String nombre;
    private int porcentaje;
    private String imagenUrl;

    public SkillDto() {
    }

    public SkillDto( String nombre,  int porcentaje, String imagenUrl) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.imagenUrl = imagenUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}