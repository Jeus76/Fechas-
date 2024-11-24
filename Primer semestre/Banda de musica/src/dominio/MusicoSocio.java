package dominio;

public class MusicoSocio extends Participante {
    private String instrumento;
    private int numeroSocio;

    public MusicoSocio(String nombre, String instrumento, int numeroSocio) {
        super(nombre);
        this.instrumento = instrumento;
        this.numeroSocio = numeroSocio;
    }

    @Override
    public String toString() {
        return getNombre() + ", " + instrumento + ", número de socio: " + numeroSocio;
    }
}