package pe.edu.upn.edad;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraEdadTest {

    private static final LocalDate HOY = LocalDate.of(2026, 9, 30);
    private static final LocalDate NACIDO_29_FEBRERO = LocalDate.of(2004, 2, 29);

    @Test
    @DisplayName("RF1: ya cumplió años este año")
    void edadCuandoYaCumplioAniosEsteAnio() {
        assertEquals(26, CalculadoraEdad.calcularEdad(LocalDate.of(2000, 5, 15), HOY));
    }

    @Test
    @DisplayName("RF2: aún no cumple años este año")
    void edadCuandoAunNoCumpleAniosEsteAnio() {
        assertEquals(25, CalculadoraEdad.calcularEdad(LocalDate.of(2000, 12, 10), HOY));
    }

    @Test
    @DisplayName("RF2: el día del cumpleaños ya cuenta el año")
    void edadElDiaDelCumpleanios() {
        assertEquals(26, CalculadoraEdad.calcularEdad(LocalDate.of(2000, 9, 30), HOY));
    }

    @Test
    @DisplayName("RF3: fecha de nacimiento futura lanza excepción")
    void fechaNacimientoFuturaLanzaExcepcion() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> CalculadoraEdad.calcularEdad(LocalDate.of(2027, 1, 1), HOY));
        assertEquals(CalculadoraEdad.MENSAJE_FECHA_FUTURA, ex.getMessage());
    }

    @Test
    @DisplayName("RF4: 28/02 en año no bisiesto aún no cumple")
    void bisiestoUnDiaAntesDelCumpleanios() {
        assertEquals(20, CalculadoraEdad.calcularEdad(NACIDO_29_FEBRERO, LocalDate.of(2025, 2, 28)));
    }

    @Test
    @DisplayName("RF4: en año no bisiesto cumple el 01/03")
    void bisiestoCumpleEl1DeMarzo() {
        assertEquals(21, CalculadoraEdad.calcularEdad(NACIDO_29_FEBRERO, LocalDate.of(2025, 3, 1)));
    }

    @Test
    @DisplayName("RF4: en año bisiesto cumple el 29/02")
    void bisiestoEnAnioBisiesto() {
        assertEquals(24, CalculadoraEdad.calcularEdad(NACIDO_29_FEBRERO, LocalDate.of(2028, 2, 29)));
    }
}