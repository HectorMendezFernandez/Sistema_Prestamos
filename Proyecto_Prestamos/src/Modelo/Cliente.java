package Modelo;

public class Cliente {

    private String cedula;

    private String nombre;

    private String provincia;

    private String Canton;

    private String distrito;

    public Cliente(String cedula, String nombre, String provincia, String canton, String distrito) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.provincia = provincia;
        Canton = canton;
        this.distrito = distrito;
    }

    public Cliente() {
        this.cedula = "";
        this.nombre = "";
        this.provincia = "";
        Canton = "";
        this.distrito = "";
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCanton() {
        return Canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCanton(String canton) {
        Canton = canton;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", provincia='" + provincia + '\'' +
                ", Canton='" + Canton + '\'' +
                ", distrito='" + distrito + '\'' +
                '}';
    }
}
