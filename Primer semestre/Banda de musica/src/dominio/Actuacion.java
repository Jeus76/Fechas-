package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Actuacion {
    private LocalDate fecha;
    private List<Participante> participantes;

    public Actuacion(LocalDate fecha) {
        this.fecha = fecha;
        this.participantes = new ArrayList<>();
    }

    public void annadirParticipante(Participante participante) {
        this.participantes.add(participante);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de actuación: ").append(fecha.toString()).append("\n");
        for (Participante participante : participantes) {
            sb.append(participante).append("\n");
        }
        return sb.toString();
    }
}