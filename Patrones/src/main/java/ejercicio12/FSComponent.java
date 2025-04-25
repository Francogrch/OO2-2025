package ejercicio12;

import java.util.List;

public interface FSComponent {
	
	public abstract int tamanioTotalOcupado();
	public abstract Archivo archivoMasGrande();
	public abstract Archivo archivoMasNuevo();
	public abstract FSComponent buscar(String nombre);
	public abstract List<FSComponent> buscarTodos(String nombre);
	public abstract String listadoDeContenido();
	public abstract String listadoDeContenidoRecu(String path);

}
