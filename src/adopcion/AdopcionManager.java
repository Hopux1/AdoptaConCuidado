package adopcion;

import modelo.Mascota;
import java.util.*;

public class AdopcionManager {
    private static AdopcionManager instancia;
    private List<Solicitud> historial = new ArrayList<>();
    private List<Mascota> disponibles = new ArrayList<>();

    private AdopcionManager() {
        // Inicializa con algunas mascotas disponibles
        disponibles.add(new modelo.Perro("Donko", "fiel y enérgico"));
        disponibles.add(new modelo.Gato("Silvestre", "independiente y tierno"));
    }

    public static AdopcionManager getInstance() {
        if (instancia == null) {
            instancia = new AdopcionManager();
        }
        return instancia;
    }

    public List<Mascota> obtenerMascotas() {
        return disponibles;
    }

    public void registrarAdopcion(Solicitud solicitud) {
        historial.add(solicitud);
    }

    public String verHistorial() {
        StringBuilder sb = new StringBuilder();
        for (Solicitud s : historial) {
            sb.append(s.getResumen()).append("\n");
        }
        return sb.toString();
    }
}