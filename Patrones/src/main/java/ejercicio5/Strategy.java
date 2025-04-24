package ejercicio5;
import java.util.List;

public interface Strategy {
	public List<Pelicula> recomendar(Decodificador context);
}
