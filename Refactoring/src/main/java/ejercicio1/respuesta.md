## 1.1 Protocolo de Cliente
La clase Cliente tiene el siguiente protocolo. ¿Cómo puede mejorarlo? 

		/** 
		* Retorna el límite de crédito del cliente
		*/
		public double lmtCrdt() {...

		/** 
		* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
		*/
		protected double mtFcE(LocalDate f1, LocalDate f2) {...

		/** 
		* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
		*/
		private double mtCbE(LocalDate f1, LocalDate f2) {...

El mal olor viene de la mala descripcion de los nombres de los metodos. No son auto-descriptivos.

Nuevos nombres:
limiteCredito()
montoFacturadoEnPeriodo()
montoCobradoEnPeriodo()


## 1.2 Participación en proyectos 
Al revisar el siguiente diseño inicial (Figura 1), se decidió realizar un cambio para evitar lo que se consideraba un mal olor. El diseño modificado se muestra en la Figura 2. Indique qué tipo de cambio se realizó y si lo considera apropiado. Justifique su respuesta.

Envidia de Caracteristicas
Feature Envy
- Mala asigancion de responsabilidad


El cambio que se realizo es de responsabilidad con respecto a las consultas de los atributos de la clase que es duenio. No tiene sentido pedirle a Proyecto siendo una Persona que me de toda su estructura para consultar si estoy dentro.

## 1.3 Cálculos 
Analice el código que se muestra a continuación. Indique qué code smells encuentra y cómo pueden corregirse.

	public void imprimirValores() {
		int totalEdades = 0;
		double promedioEdades = 0;
		double totalSalarios = 0;
		
		for (Empleado empleado : personal) {
			totalEdades = totalEdades + empleado.getEdad();
			totalSalarios = totalSalarios + empleado.getSalario();
		}
		promedioEdades = totalEdades / personal.size();
			
		String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
		
		System.out.println(message);
	}

Bad smell: Metodo largo
Solucion: Extract method

	public void impirmirValores(){
		System.out.println(String.format("El promedio de las edades es %s y el total de los salarios es %s", this.getPromedioEdades(), this.getPromedioEdades()))
	}

	public double getPromedioEdades(){
		return (personal.stream().mapToInt(e --> e.getEdad()).sum()) / personal.size();
	}

	public double getTotalSalarios(){
		return personal.stream().mapToDouble(e -> e.getSalario()).sum();
	}

El problema que hacerlo de esta manera tendria que recorrer dos veces la lista. Aunque queda mucho mas cohesivo. 
Correccion: no importa si es menos eficiente, el sombrero que hay que ponerse es el del refactoring.






		
					
					
					