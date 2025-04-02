package ejercicio2.sub6;

public class SuscripcionFamilia extends Suscripcion{
	public double costoAgregado(Pelicula peli) {
		return peli.calcularCostoExtraPorEstreno() * 0.90 - (peli.getCosto() * 0.10 );
	}

}
