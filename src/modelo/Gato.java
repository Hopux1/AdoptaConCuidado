package modelo;

public class Gato extends Mascota {
    private String nombre;
    private String descripcion;

    public Gato(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return "- " + nombre + ": " + descripcion;
    }
}