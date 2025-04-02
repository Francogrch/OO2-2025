package ejercicio2.sub6;

public class SuscripcionPremium extends Suscripcion{
	public double costoAgregado(Pelicula peli) {
		return -(peli.getCosto() * 0.25);
	}
}
