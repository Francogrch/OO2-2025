## Ejercicio 2.1

	public class EmpleadoTemporario {
		public String nombre;
		public String apellido;
		public double sueldoBasico = 0;
		public double horasTrabajadas = 0;
		public int cantidadHijos = 0;
		// ......
		
	public double sueldo() {
	return this.sueldoBasico
	(this.horasTrabajadas * 500) 
	(this.cantidadHijos * 1000) 
	(this.sueldoBasico * 0.13);
	}
	}


	public class EmpleadoPlanta {
		public String nombre;
		public String apellido;
		public double sueldoBasico = 0;
		public int cantidadHijos = 0;
		// ......
		
		public double sueldo() {
			return this.sueldoBasico 
	+ (this.cantidadHijos * 2000)
	- (this.sueldoBasico * 0.13);
		}
	}

	public class EmpleadoPasante {
		public String nombre;
		public String apellido;
		public double sueldoBasico = 0;
		// ......
		
		public double sueldo() {
			return this.sueldoBasico - (this.sueldoBasico * 0.13);
		}
	}
	
(i) Bad Smell: Codigo duplicado. Cambios divergentes???
(ii) En este caso la solucion seria hacer un pull up method, creando una clase abstracta con los atributos y el metodo sueldo;
(iii) Implementado

## 2.2 Juego 

	public class Juego {
		// ......
		public void incrementar(Jugador j) {
			j.puntuacion = j.puntuacion + 100;
		}
		public void decrementar(Jugador j) {
			j.puntuacion = j.puntuacion - 50;
		}

	public class Jugador {
		public String nombre;
		public String apellido;
		public int puntuacion = 0;
	}

(i) Bad Smell: Feature Envy
(ii) En esta caso la solucion es mover haver responsable al jugador para incrementar o decrementar la puntuacion. Un move method??


## Publicaciones

(i) Bad Smell: Feature Envy, Inappropriate Intimacy, Cambios divergente, Large Method
(ii) El usuario tiene que tener el listado de posts, ya que el es el responsable de sus posts, el filtrado es mas eficiente si lo hace el usuario. Por eso mismo el usuario tiene un metodo para filtrarlo. En PostApp el metodo es demasiado largo, lo mejor es extraerlo.








