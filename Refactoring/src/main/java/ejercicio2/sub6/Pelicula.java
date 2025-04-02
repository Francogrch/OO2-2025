package ejercicio2.sub6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pelicula {
	private String nombre,genero;
	private LocalDate fechaEstreno;
	private double costo;
	
	
	public double getCosto() {
		return costo;
	}
	public double calcularCostoExtraPorEstreno() {
		return esNueva() ? 0 : 300;
	}
	public double calcularCostoSus(Suscripcion sus) {
		return sus.costoPelicula(this);
	}
	private boolean esNueva() {
		return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30;
	}
}
