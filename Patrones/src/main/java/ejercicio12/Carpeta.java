package ejercicio12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carpeta implements FSComponent{
	private String nombre;
	private LocalDate fecha;
	private List<FSComponent> childs;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		fecha = LocalDate.now();
		childs = new ArrayList<FSComponent>();
	}


	public void addChild(FSComponent o) {
		childs.add(o);
	}
	public void removeChild(FSComponent o) {
		childs.remove(o);
	}
	public List<FSComponent> getChild(){
		return childs;
	}
	
	@Override
	public int tamanioTotalOcupado() {
		return childs.stream().mapToInt(c -> c.tamanioTotalOcupado()).sum();
	}

	@Override
	// Directorio raiz vacio retorna archivo vacio
	public Archivo archivoMasGrande() {
		Archivo mayor = new Archivo("");
		for (FSComponent c:childs) {
			if (c.archivoMasGrande().getTamanio() > mayor.getTamanio()) {
				mayor = (Archivo) c;
			}
		}
		return mayor;
	}

	@Override
	// Directorio raiz vacio retorna archivo vacio
	public Archivo archivoMasNuevo() {
		Archivo mayor = new Archivo("");
		mayor.setFechaCreacion(LocalDate.MIN);
		for (FSComponent c:childs) {
			if (c.archivoMasGrande().getFechaCreacion().isAfter(mayor.getFechaCreacion())) {
				mayor = (Archivo) c;
			}
		}
		return mayor;
	}

	@Override
	public FSComponent buscar(String nombre) {
		return childs.stream().map(c -> c.buscar(nombre)).filter(c -> c != null).findFirst().orElse(null);
		
	}

	@Override
	public List<FSComponent> buscarTodos(String nombre) {
		return childs.stream().map(c -> c.buscar(nombre)).filter(c -> c != null).collect(Collectors.toList());
	}

	@Override
	public String listadoDeContenido() {
		return listadoDeContenidoRecu(this.nombre);
		}
	public String listadoDeContenidoRecu(String path) {
		String completo = path;
		
		for (FSComponent c:childs) {
			completo = completo.concat(nombre+ c.listadoDeContenidoRecu(path));
			completo = completo.concat("\n");
		}
		return completo;
	}

}
