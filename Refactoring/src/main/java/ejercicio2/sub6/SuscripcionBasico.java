package ejercicio2.sub6;


public class SuscripcionBasico extends Suscripcion{
	public double costoAgregado(Pelicula peli) {
		return peli.calcularCostoExtraPorEstreno();
	}

}
