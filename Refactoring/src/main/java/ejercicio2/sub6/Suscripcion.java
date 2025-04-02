package ejercicio2.sub6;

public abstract class Suscripcion {
	public double costoPelicula(Pelicula peli) {
		return peli.getCosto() + this.costoAgregado(peli);
	}
	
	protected abstract double costoAgregado(Pelicula peli);

}
