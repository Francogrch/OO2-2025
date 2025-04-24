package ejercicio5;
import java.util.List;
import java.util.ArrayList;

public class Decodificador {
	private List<Pelicula> peliculas, reproducidas;
	private Strategy strategy;
 
	public List<Pelicula> recomendar(){
		return strategy.recomendar(this);
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public List<Pelicula> getReproducidas() {
		return reproducidas;
	}
	
	
}
