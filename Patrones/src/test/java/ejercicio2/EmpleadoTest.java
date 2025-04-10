package ejercicio2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTest {
	Empleado empTmpCas,empTmpNoCas,empPasan,empPlantCas,empPlantNoCas;

	@BeforeEach
	void EmpleadoTest() {
		empTmpCas = new EmpleadoTemporario(38, 3, true);
		empTmpNoCas = new EmpleadoTemporario(38, 3, false );
		empPasan = new EmpleadoPasante(4);
		empPlantCas = new EmpleadoPlanta(28,3,true);
		empPlantNoCas = new EmpleadoPlanta(28,3,false);
	}
	@Test
	void pagarTest() {
		assertEquals(empTmpCas.pagar(),37768);
		assertEquals(empTmpNoCas.pagar(),33018);
		assertEquals(empPasan.pagar(),25000);
		assertEquals(empPlantCas.pagar(),107150);
		assertEquals(empPlantNoCas.pagar(),102400);
	}

}
