package modelo;

public class Perro extends Mascota {
    private String nombre;
    private String descripcion;

    public Perro(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return "- " + nombre + ": " + descripcion;
    }
}