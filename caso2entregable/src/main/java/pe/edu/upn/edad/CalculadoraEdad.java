package pe.edu.upn.edad;

import java.time.LocalDate;

public class CalculadoraEdad {

    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser posterior a la fecha actual");
        }
        int diferenciaAnios = fechaActual.getYear() - fechaNacimiento.getYear();

        boolean mesAnterior = fechaActual.getMonthValue() < fechaNacimiento.getMonthValue();
        boolean mismoMesDiaAnterior = fechaActual.getMonthValue() == fechaNacimiento.getMonthValue()
                && fechaActual.getDayOfMonth() < fechaNacimiento.getDayOfMonth();
        boolean cumpleaniosPendiente = mesAnterior || mismoMesDiaAnterior;

        return cumpleaniosPendiente ? diferenciaAnios - 1 : diferenciaAnios;
    }
}