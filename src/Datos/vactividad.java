
package Datos;

/**
 *
 * @author Sergio
 */
public class vactividad {
    private int idactividad;
    private String tipo;
    private String titulo;
    private String duracion;        
    private String lugar;

    public vactividad(int idactividad, String tipo, String titulo, String duracion, String lugar) {
        this.idactividad = idactividad;
        this.tipo = tipo;
        this.titulo = titulo;
        this.duracion = duracion;
        this.lugar = lugar;
    }

    public vactividad() {
    }

    public int getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(int idactividad) {
        this.idactividad = idactividad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    
    
    
    
}
