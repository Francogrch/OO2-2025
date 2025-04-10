package ejercicio2;

public class EmpleadoTemporario extends Empleado{
	private int horasTrabajadas, cantHijos;
	private boolean casado;
	
	public EmpleadoTemporario(int horasTrabajadas, int cantHijos, boolean casado) {
		this.horasTrabajadas = horasTrabajadas;
		this.cantHijos = cantHijos;
		this.casado = casado;
	}

	protected double getBasico() {
		return 20000 + (300 * horasTrabajadas);
	}
	
	protected double getAdicional() {
		return casado ? 5000 + (2000*cantHijos) : (2000*cantHijos);
	}
}
