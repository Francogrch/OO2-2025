package ejercicio5;
import java.util.List;

public class StrategyPuntaje implements Strategy{
	public List<Pelicula> recomendar(Decodificador context){
		return context.getPeliculas().stream().sorted((p1,p2) -> Double.compare(p1.getPuntaje(),p2.getPuntaje())).limit(3).toList();
	};
}