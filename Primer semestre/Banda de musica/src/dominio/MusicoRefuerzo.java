package dominio;

import java.math.BigDecimal;

public class MusicoRefuerzo extends Participante {
    private String instrumento;
    private BigDecimal compensacion;

    public MusicoRefuerzo(String nombre, String instrumento, BigDecimal compensacion) {
        super(nombre);
        this.instrumento = instrumento;
        this.compensacion = compensacion;
    }

    @Override
    public String toString() {
        return getNombre() + ", " + instrumento + ", " + compensacion + " €";
    }
}