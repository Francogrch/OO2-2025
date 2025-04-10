package ejercicio2;

public abstract class Empleado {

	public double pagar() {
		return this.getBasico()+this.getAdicional() - this.getDescuento();
	}
	public double getDescuento() {
		return this.getBasico()*0.13 + this.getAdicional()*0.05;
	}
	protected abstract double getBasico();
	protected abstract double getAdicional();
}
