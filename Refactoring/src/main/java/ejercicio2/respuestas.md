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
Arreglar otra clase abstracta con cantidad de hijos y sueldo hay calores que se repiten.

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

(i) Bad Smell: Feature Envy y mala delegacion de responsabilidad
(ii) En esta caso la solucion es mover haver responsable al jugador para incrementar o decrementar la puntuacion. Un move method??


## 2.3 Publicaciones

(i) Bad Smell: Feature Envy, Inappropriate Intimacy, Cambios divergente, Large Method
(ii) Con cambio en el disenio - El usuario tiene que tener el listado de posts, ya que el es el responsable de sus posts, el filtrado es mas eficiente si lo hace el usuario. Por eso mismo el usuario tiene un metodo para filtrarlo. En PostApp el metodo es demasiado largo, lo mejor es extraerlo.

(ii) Sin cambio de disenio - Hay que extraer todas las funcionalidades que hace el metodo, dejando de utilizar variables temporales. Extract method.

## 2.4 Carrito de compras

	public class Producto {
		private String nombre;
		private double precio;
		
		public double getPrecio() {
			return this.precio;
		}
	}
	public class ItemCarrito {
		private Producto producto;
		private int cantidad;
			
		public Producto getProducto() {
			return this.producto;
		}
		
		public int getCantidad() {
			return this.cantidad;
		}

	}

	public class Carrito {
		private List<ItemCarrito> items;
		
		public double total() {
	return this.items.stream()
	.mapToDouble(item -> 
	item.getProducto().getPrecio() * item.getCantidad())
	.sum();
		}
	}

(i) Envidia de atributos en el calculculo del precio del itemCarrito, mala asignacion de responsabilidad.
(ii) La solucion es hacer un metodo en itemCarrito que calcule su precio, ya que la responsabilidad de este calculo es del itemCarrito.
(iii) Implementado

## 2.5 Envio de pedidos
	public class Supermercado {
	   public void notificarPedido(long nroPedido, Cliente cliente) {
		 String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, cliente.getDireccionFormateada() });

		 // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
		System.out.println(notificacion);
	  }
	}

	public class Cliente {
	   public String getDireccionFormateada() {
		return 
			this.direccion.getLocalidad() + “, ” +
			this.direccion.getCalle() + “, ” +
			this.direccion.getNumero() + “, ” +
			this.direccion.getDepartamento()
		  ;
	}

(i) Envidia de atributos
(ii) El cliente esta haceindo envidia de atributos y mala gestion de la responsabilidad del armado del string de la direccion formateada, ya que toda esa informacion ya la tiene el objeto direccion.
(iii) Lo que cambia es que direccion tiene un toString() y el Cliente directamente llama a este toString


## Ejercicio 2.6 Peliculas

	public class Usuario {
		String tipoSubscripcion;
		// ...

		public void setTipoSubscripcion(String unTipo) {
			this.tipoSubscripcion = unTipo;
		}
		
		public double calcularCostoPelicula(Pelicula pelicula) {
			double costo = 0;
			if (tipoSubscripcion=="Basico") {
				costo = pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
			}
			else if (tipoSubscripcion== "Familia") {
				costo = (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
			}
			else if (tipoSubscripcion=="Plus") {
				costo = pelicula.getCosto();
			}
			else if (tipoSubscripcion=="Premium") {
				costo = pelicula.getCosto() * 0.75;
			}
			return costo;
		}
	}

	public class Pelicula {
		LocalDate fechaEstreno;
		// ...

		public double getCosto() {
			return this.costo;
		}
		
		public double calcularCargoExtraPorEstreno(){
		// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
		   return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
		}
	}
### UML 

	@startuml
	class HBOO {}

	class Usuario{
	-nombre: String
	-telefono: Integer
	-tipoSubscripcion:String
	-email:String
	+calcularCostoPelicula(Pelicula pelicula):Real
	}

	class Pelicula{
	-nombre:String
	-genero:String
	-fechaEstreno: Date
	-costo:Real
	+getCosto():Real
	+calcularCargoExtraPorEstreno():Real

	}
	HBOO --> Usuario : -usuarios 0..*
	HBOO --> Pelicula : -peliculas 0..*
	Usuario --> Pelicula: -peliculasCompradas 0..*

	@enduml
	
(i) Large Method calcularCostoPelicula, mala resposabilidad en Usuario, la pelicula tiene que conocer su costo. Demasiados ifs. En el calcularCargoExtraPorEstreno la utilizacion del comentario explicando es un mal olor

(ii)Primero es sacar todos los ifs utilizando polimorfismo, y luego darle la resposabilidad del calcular costo a la pelicula, moviendo el calculo a la clase pelicula. En calcularCargoExtraPorEstreno es necesario extraer un metodo que sea descriptivo, que haga la verificacion si es nueva o no.

### Solucion
#### UML
@startuml
class HBOO {}

class Usuario{
-nombre: String
-telefono: Integer
-email:String

}
Usuario --> Suscripcion : suscripcion

class Pelicula{
-nombre:String
-genero:String
-fechaEstreno: Date
-costo:Real
+getCosto():Real
+calcularCargoExtraPorEstreno():Real
+calcularCostoSus(suscripcion:Suscripcion):Real
-esNueva():boolean
}

HBOO --> Usuario : -usuarios 0..*
HBOO --> Pelicula : -peliculas 0..*
Usuario --> Pelicula: -peliculasCompradas 0..*

abstract class Suscripcion{
+costoPelicula(pelicula: Pelicula):Real
+abstract costoAgregado(pelicula: Pelicula):Real
}
class SuscripcionFamilia extends Suscripcion{
+costoPelicula(pelicula: Pelicula):Real
+costoAgregado(pelicula: Pelicula):Real
}
class SuscripcionBasico extends Suscripcion{
+costoPelicula(pelicula: Pelicula):Real
+costoAgregado(pelicula: Pelicula):Real
}
class SuscripcionPlus extends Suscripcion{
+costoPelicula(pelicula: Pelicula):Real
+costoAgregado(pelicula: Pelicula):Real
}
class SuscripcionPremium extends Suscripcion{
+costoPelicula(pelicula: Pelicula):Real
+costoAgregado(pelicula: Pelicula):Real
}
@enduml

Las clases ya estan implementadas en su respectivo paquete.
Es necesario que usuario continue con el mismo metodo o ya no?
















