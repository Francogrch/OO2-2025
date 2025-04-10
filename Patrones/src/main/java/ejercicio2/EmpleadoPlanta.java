package ejercicio2;

public class EmpleadoPlanta extends Empleado{
	
	private int aniosAntiguedad, cantHijos;
	private boolean casado;
	
	public EmpleadoPlanta(int aniosAntiguedad, int cantHijos, boolean casado) {
		this.aniosAntiguedad = aniosAntiguedad;
		this.cantHijos = cantHijos;
		this.casado = casado;
	}

	protected double getBasico() {
		return 50000;
	}
	
	protected double getAdicional() {
		double adicional = (2000*cantHijos) + (2000*aniosAntiguedad);
		return casado ? 5000 + adicional: adicional;
	}
}
