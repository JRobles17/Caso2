package pe.edu.upn.edad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class CalculadoraEdadTest {

    @Test
    void edadCuandoYaCumplioAniosEsteAnio() {
        LocalDate nacimiento = LocalDate.of(2000, 5, 15);
        LocalDate hoy = LocalDate.of(2026, 9, 30);
        assertEquals(26, CalculadoraEdad.calcularEdad(nacimiento, hoy));
    }

        @Test
    void edadCuandoAunNoCumpleAniosEsteAnio() {
        LocalDate nacimiento = LocalDate.of(2000, 12, 10);
        LocalDate hoy = LocalDate.of(2026, 9, 30);
        assertEquals(25, CalculadoraEdad.calcularEdad(nacimiento, hoy));
    }

    @Test
    void edadElDiaDelCumpleanios() {
        LocalDate nacimiento = LocalDate.of(2000, 9, 30);
        LocalDate hoy = LocalDate.of(2026, 9, 30);
        assertEquals(26, CalculadoraEdad.calcularEdad(nacimiento, hoy));
    }

        @Test
    void fechaNacimientoFuturaLanzaExcepcion() {
        LocalDate nacimiento = LocalDate.of(2027, 1, 1);
        LocalDate hoy = LocalDate.of(2026, 9, 30);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> CalculadoraEdad.calcularEdad(nacimiento, hoy));
        assertEquals("La fecha de nacimiento no puede ser posterior a la fecha actual", ex.getMessage());
    }
}