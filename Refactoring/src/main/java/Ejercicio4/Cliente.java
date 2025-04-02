package Ejercicio4;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
	private LocalDate fechaAlta;
	public LocalDate getFechaAlta() {
		return this.fechaAlta;
	}
	
	public int aniosDesdeAlta() {
     return Period.between(this.getFechaAlta(), LocalDate.now()).getYears();
   }
	
	public boolean mayorA5() {
		return aniosDesdeAlta() > 5;
	}

}
