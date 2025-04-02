## Ejercicio 3
Dado el siguiente código implementado en la clase Document y que calcula algunas estadísticas del mismo:

	public class Document {
		List<String> words;
	  
		public long characterCount() {
		 	long count = this.words.stream() .mapToLong(w -> w.length()) .sum();
			return count;
		}
		public long calculateAvg() {
			long avgLength = this.words .stream() .mapToLong(w -> w.length()) .sum() / this.words.size();
		 	return avgLength;
		}
	// Resto del código que no importa
	}


Tareas:
### 1.Enumere los code smell y que refactorings utilizará para solucionarlos.
- uso de variables Temporales --> retornar directamente el resultado
- codigo repetido --> extraer ese codigo a un metodo
- variable de instancia publica --> hacerla privada

### 2.Aplique los refactorings encontrados, mostrando el código refactorizado luego de aplicar cada uno.

codigo repetido	

	public class Document {
		List<String> words;
	  
		public long characterCount() {
		 long count = this.words
	.stream()
	.mapToLong(w -> w.length())
	.sum();
			return count;
		}
		public long calculateAvg() {
			long avgLength = characterCount() / this.words.size();
		 return avgLength;
		}
	// Resto del código que no importa
	}

variables temporales 		

	public class Document {
		List<String> words;
	  
		public long characterCount() {
			return this.words .stream() .mapToLong(w -> w.length()) .sum();
		}
		public long calculateAvg() {
			return characterCount() / this.words.size();
		}
	// Resto del código que no importa
	}

variables publicas	

	public class Document {
		private List<String> words;
	  
		public long characterCount() {
			return this.words .stream() .mapToLong(w -> w.length()) .sum();
		}
		public long calculateAvg() {
			return characterCount() / this.words.size();
		}
	// Resto del código que no importa
	}

### 3.Analice el código original y detecte si existe un problema al calcular las estadísticas. Explique cuál es el error y en qué casos se da ¿El error identificado sigue presente luego de realizar los refactorings? En caso de que no esté presente, ¿en qué momento se resolvió? De acuerdo a lo visto en la teoría, ¿podemos considerar esto un refactoring?

El posible error es que para agregar una nueva funcionalidad de estadistica sobre el documento, quedaria una clase muy larga. Lo ideal seria hacer otra clase estatica que haga estos calculos recibiendo la lista de palabras. Y si, seria un refactoring, porque inclusive quedaria mucho mas descriptivo que antes.


