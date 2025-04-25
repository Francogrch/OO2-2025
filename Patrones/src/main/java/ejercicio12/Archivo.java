package ejercicio12;

import java.time.LocalDate;
import java.util.List;

public class Archivo implements FSComponent{
	private String nombre;
	private LocalDate fechaCreacion;

	public Archivo(String nombre) {
		this.nombre = nombre;
		fechaCreacion = LocalDate.now();
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fecha) {
		fechaCreacion = fecha;
	}

	public int getTamanio() {
		return nombre.length() + 32;
	}

	@Override
	public int tamanioTotalOcupado() {
		return getTamanio();
	}

	@Override
	public Archivo archivoMasGrande() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Archivo archivoMasNuevo() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public FSComponent buscar(String nombre) {
		
		return (nombre.equals(this.nombre))? this :null;
	}

	@Override
	// Que hago aca???
	public List<FSComponent> buscarTodos(String nombre) {
		// TODO Auto-generated method stub
		return  null;
	}

	@Override
	public String listadoDeContenido() {
		return "/"+nombre;
	}
	@Override
	public String listadoDeContenidoRecu(String path) {
		return path+"/"+nombre;
	}



}
