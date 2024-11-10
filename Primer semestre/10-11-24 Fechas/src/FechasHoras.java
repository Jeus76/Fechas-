import java.time.*;
import java.time.format.DateTimeFormatter;

public class FechasHoras {

    public static void main(String[] args) {
        // Definir el ZoneId de Caracas y Madrid
        ZoneId zonaCaracas = ZoneId.of("America/Caracas");
        ZoneId zonaMadrid = ZoneId.of("Europe/Madrid");

        // Formato de fecha y hora
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatoLuna = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // 1. Fecha actual local (Madrid)
        LocalDate fechaActualMadrid = LocalDate.now(zonaMadrid);
        System.out.println("Fecha actual en Madrid: " + fechaActualMadrid.format(formatoFecha));

        // 2. Fecha actual en Caracas usando ZoneId (en lugar de ZoneOffset)
        ZonedDateTime fechaActualCaracas = ZonedDateTime.now(zonaCaracas);
        System.out.println("Fecha actual en Caracas: " + fechaActualCaracas.format(formatoFecha));

        // 3. Años transcurridos desde el descubrimiento de América (1492)
        int añoDescubrimiento = 1492;
        int añoActual = LocalDate.now().getYear();
        int añosDesdeDescubrimiento = añoActual - añoDescubrimiento;
        System.out.println("Años transcurridos desde el descubrimiento de América: " + añosDesdeDescubrimiento);

        // 4. Hora actual local (Madrid)
        LocalTime horaActualMadrid = LocalTime.now(zonaMadrid);
        System.out.println("Hora actual en Madrid: " + horaActualMadrid.format(formatoHora));

        // 5. Hora actual en Caracas usando ZoneId (en lugar de ZoneOffset)
        LocalTime horaActualCaracas = LocalTime.now(zonaCaracas);
        System.out.println("Hora actual en Caracas: " + horaActualCaracas.format(formatoHora));

        // 6. Diferencia de horas entre Madrid y Caracas
        // Usamos una fecha fija para asegurarnos de que hay diferencia en las zonas horarias
        ZonedDateTime ahoraMadrid = ZonedDateTime.of(2024, 11, 10, 12, 0, 0, 0, zonaMadrid);
        ZonedDateTime ahoraCaracas = ZonedDateTime.of(2024, 11, 10, 12, 0, 0, 0, zonaCaracas);

        // Calcular la diferencia entre ambas zonas horarias
        Duration diferencia = Duration.between(ahoraCaracas, ahoraMadrid);
        long diferenciaHoras = diferencia.toHours();
        System.out.println("Horas de diferencia entre Madrid y Caracas: " + diferenciaHoras);

        // 7. Fecha y hora cuando Neil Armstrong pisó la luna (21 de julio de 1969 a las 3:56 en Madrid)
        LocalDateTime fechaHoraAlunizaje = LocalDateTime.of(1969, 7, 21, 3, 56);
        ZonedDateTime alunizajeEnMadrid = fechaHoraAlunizaje.atZone(zonaMadrid);
        System.out.println("Neil Armstrong pisó la luna el: " + alunizajeEnMadrid.format(formatoLuna));
    }
}
