package ejercicio2;

public abstract class Empleado{
	private String nombre,apellido;
	private double sueldoBasico;
	
	public Empleado(String nombre,String apellido, double sueldoBasico) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.sueldoBasico=sueldoBasico;
	}

	
	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public double getSueldoBasico() {
		return sueldoBasico;
	}


	abstract public double sueldo();

}
