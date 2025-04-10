package ejercicio2;

public class EmpleadoPasante extends Empleado{
	private int cantExamenes;
	
	public EmpleadoPasante(int cantExamenes) {
		this.cantExamenes = cantExamenes;
	}

	protected double getBasico() {
		return 20000; 
	}
	
	protected double getAdicional() {
		return 2000*cantExamenes;
	}

}
