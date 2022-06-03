
package Datos;

/**
 *
 * @author Sergio
 */
public class vponente {
    private int idponente;
    private String nombre;
    private String apaterno;
    private String amaterno;        
    private String correo;
    private String telefono;
    private String nacionalidad;
    private String especialidad;

    public vponente(int idponente, String nombre, String apaterno, String amaterno, String correo, String telefono, String nacionalidad, String especialidad) {
        this.idponente = idponente;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
        this.especialidad = especialidad;
    }

    public vponente() {
    }
    
    public int getIdponente() {
        return idponente;
    }

    public void setIdponente(int idponente) {
        this.idponente = idponente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
    
    
}
