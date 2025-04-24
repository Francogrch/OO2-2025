package ejercicio5;
import java.util.List;
import java.util.ArrayList;

public class Pelicula {
	private String titulo;
	private int anio;
	private double puntaje;
	private List<Pelicula> similares;
	
	public Pelicula(String titulo, int anio, double puntaje) {
		this.titulo = titulo;
		this.anio = anio;
		this.puntaje = puntaje;
		this.similares = new ArrayList<Pelicula>();
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	public List<Pelicula> getSimilares() {
		return similares;
	}

	public void setSimilares(List<Pelicula> similares) {
		this.similares = similares;
	}
	
	public int compareTo(Pelicula pelicula) {
	    return Integer.compare(pelicula.getAnio(), this.getAnio());
	}
	
	
}
