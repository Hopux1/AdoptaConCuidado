package modelo;

public class MascotaFactory {
    public static Mascota crearMascota(String tipo) {
        switch (tipo.toLowerCase()) {
            case "perro":
                return new Perro("Donko", "fiel y enérgico");
            case "gato":
                return new Gato("Silvestre", "independiente y tierno");
            case "loro":
                return new Perro("Kayser", "hablador y divertido");
            case "conejo":
                return new Perro("Bruno", "tranquilo y suave");
            case "hamster":
                return new Perro("Doki", "pequeño y juguetón");
            default:
                return null;
        }
    }
}