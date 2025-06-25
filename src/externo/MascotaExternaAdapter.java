package externo;

import modelo.Mascota;

// Adapter para integrar clases externas como mascotas compatibles
public class MascotaExternaAdapter extends Mascota {
    private String descripcionExterna;

    public MascotaExternaAdapter(String desc) {
        this.descripcionExterna = desc;
    }

    public String getDescripcion() {
        return "Mascota externa: " + descripcionExterna;
    }
}