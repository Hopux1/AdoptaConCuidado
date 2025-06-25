package adopcion;

import modelo.Mascota;

public class Solicitud {
    private String nombrePersona;
    private Mascota mascota;

    public Solicitud(String nombrePersona, Mascota mascota) {
        this.nombrePersona = nombrePersona;
        this.mascota = mascota;
    }

    public String getResumen() {
        return nombrePersona + " adoptó: " + mascota.getDescripcion();
    }
}