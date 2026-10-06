package pe.edu.upn.edad;

import java.time.LocalDate;

public class CalculadoraEdad {
static final String MENSAJE_FECHA_FUTURA = "La fecha de nacimiento no puede ser posterior a la fecha actual";

    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new IllegalArgumentException(MENSAJE_FECHA_FUTURA);        }
        int diferenciaAnios = fechaActual.getYear() - fechaNacimiento.getYear();

        boolean mesAnterior = fechaActual.getMonthValue() < fechaNacimiento.getMonthValue();
        boolean mismoMesDiaAnterior = fechaActual.getMonthValue() == fechaNacimiento.getMonthValue()
                && fechaActual.getDayOfMonth() < fechaNacimiento.getDayOfMonth();
        boolean cumpleaniosPendiente = mesAnterior || mismoMesDiaAnterior;

        return cumpleaniosPendiente ? diferenciaAnios - 1 : diferenciaAnios;
    }
}