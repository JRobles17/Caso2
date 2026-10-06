package pe.edu.upn.edad;

import java.time.LocalDate;

public class CalculadoraEdad {

    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        return fechaActual.getYear() - fechaNacimiento.getYear();
    }
}