package Modelo;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Fecha{

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    LocalDate fechaActual = LocalDate.now();
    LocalTime horaActual = LocalTime.now();
    String fechaString = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); //estalece el formato en el que lo quiero pasar a String
    String horaString = horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    public String getFechaString() {
        return fechaString;
    }

    public String getHoraString() {
        return horaString;
    }
}
