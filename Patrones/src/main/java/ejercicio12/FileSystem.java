package ejercicio12;

import java.util.List;

public class FileSystem {
	private Carpeta raiz;


	public FileSystem() {
		raiz = new Carpeta("");
	}
	public Carpeta getRaiz() {
		return raiz;
	}
	public int tamanioTotalOcupado() {
		return raiz.tamanioTotalOcupado();
	}
	public Archivo archivoMasGrande() {
		return raiz.archivoMasGrande();
	}
	public Archivo archivoMasNuevo() {
		return raiz.archivoMasNuevo();
	}
	public FSComponent buscar(String nombre) {
		return raiz.buscar(nombre);
	}
	public List<FSComponent> buscarTodos(String nombre) {
		return raiz.buscarTodos(nombre);
	}
	public String listadoDeContenido() {
		return raiz.listadoDeContenido();
	};
	
}
