package pe.edu.upn.edad;

import java.time.LocalDate;
import java.time.MonthDay;

public final class CalculadoraEdad {

    static final String MENSAJE_FECHA_FUTURA =
            "La fecha de nacimiento no puede ser posterior a la fecha actual";

    private CalculadoraEdad() {
        //no se instancia
    }

    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        validarFechaNacimiento(fechaNacimiento, fechaActual);
        int diferenciaAnios = fechaActual.getYear() - fechaNacimiento.getYear();
        return yaCumplioAnios(fechaNacimiento, fechaActual) ? diferenciaAnios : diferenciaAnios - 1;
    }

    private static void validarFechaNacimiento(LocalDate fechaNacimiento, LocalDate fechaActual) {
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new IllegalArgumentException(MENSAJE_FECHA_FUTURA);
        }
    }

    private static boolean yaCumplioAnios(LocalDate fechaNacimiento, LocalDate fechaActual) {
        MonthDay cumpleanios = MonthDay.from(fechaNacimiento);
        MonthDay hoy = MonthDay.from(fechaActual);
        return !hoy.isBefore(cumpleanios);
    }
}