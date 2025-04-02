package ejercicio2;

import java.time.LocalDate;

public class Post {
    private	LocalDate fecha;
    private String texto;
    private Usuario user;
    
    public Usuario getUsuario() {
    	return user;
    }
	
	public LocalDate getFecha() {
		return fecha;
	}
}
