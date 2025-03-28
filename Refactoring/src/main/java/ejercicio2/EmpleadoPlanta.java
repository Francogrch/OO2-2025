package ejercicio2;

public class EmpleadoPlanta extends Empleado{
    public int cantidadHijos = 0;
    // ......
   public EmpleadoPlanta(String nombre,String apellido,double sueldoBasico,int cantidadHijos) {
	   super(nombre,apellido,sueldoBasico);
	   this.cantidadHijos=cantidadHijos;
   } 
    public double sueldo() {
        return this.getSueldoBasico() + (this.cantidadHijos * 2000) - (this.getSueldoBasico() * 0.13);
    }
}
