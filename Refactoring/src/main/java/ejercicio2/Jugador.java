package ejercicio2;
public class Jugador {
	    public String nombre;
	    public String apellido;
	    public int puntuacion = 0;
	    
	    public void aumentarPuntuacionEn(int valor) {
	    	puntuacion = puntuacion + valor;
	    }
	    
	     public void disminuirPuntuacionEn(int valor) {
	    	puntuacion = puntuacion - valor;
	    }
	    
}

