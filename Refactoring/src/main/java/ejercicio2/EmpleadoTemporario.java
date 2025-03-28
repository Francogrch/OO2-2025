package ejercicio2;

public class EmpleadoTemporario extends Empleado{
    public double horasTrabajadas = 0;
    public int cantidadHijos;
    // ......
   public EmpleadoTemporario(String nombre,String apellido,double sueldoBasico,int cantidadHijos) {
	   super(nombre,apellido,sueldoBasico);
	   this.cantidadHijos=cantidadHijos;
   } 
    
    public double sueldo() {
    	return this.getSueldoBasico() + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000) + (this.getSueldoBasico() * 0.13);
	}

}
