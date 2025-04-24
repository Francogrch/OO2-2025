package ejercicio5;
import java.util.List;
import java.util.stream.Collectors;
public class StrategySimilar implements Strategy{

	private List<Pelicula> similares(List<Pelicula> peliculas){
		return (List<Pelicula>) peliculas.stream().flatMap(p -> p.getSimilares().stream()).collect(Collectors.toSet());
	}
	
	public List<Pelicula> recomendar(Decodificador context){
		return similares(context.getReproducidas()).stream().sorted((p1,p2) -> p1.compareTo(p2)).limit(3).toList();
	};
}