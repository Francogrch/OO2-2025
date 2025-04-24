package ejercicio5;
import java.util.List;
public class StrategyNovedad implements Strategy{

	public List<Pelicula> recomendar(Decodificador context){
		return context.getPeliculas().stream().sorted((p1,p2) -> p1.compareTo(p2)).limit(3).toList();
	};
}
