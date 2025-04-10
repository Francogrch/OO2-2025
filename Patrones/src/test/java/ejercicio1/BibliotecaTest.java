package ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


class BibliotecaTest {
	Biblioteca biblioteca;
 @BeforeEach
 void BibliotecaTest() {
	 biblioteca = new Biblioteca();
	 biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
	 biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com",  "2345-2"));
 }
 
 @Test
 void exportarSocioTest() {
	 List<Map<String, String>> objetos = parsearJson(biblioteca.exportarSocios());
	 Iterator<Map<String, String>> it = objetos.iterator();
	
	 if (it.hasNext()) {
		 Map<String, String> persona = it.next();
		 assertTrue(persona.get("nombre").equals("Arya Stark"));	
		 assertTrue(persona.get("email").equals("needle@stark.com"));	
		 assertTrue(persona.get("legajo").equals("5234-5"));	
	 }
 }
 
 public static List<Map<String, String>> parsearJson(String json) {
     List<Map<String, String>> personas = new ArrayList<>();

     // Limpiar los corchetes externos y espacios
     json = json.replace("[", "")
                .replace("]", "")
                .trim();

     // Separar objetos individuales
     String[] objetos = json.split("\\},\\s*\\{");

     for (String obj : objetos) {
         obj = obj.replace("{", "").replace("}", "").trim();
         String[] campos = obj.split(",\\s*");

         Map<String, String> persona = new HashMap<>();
         for (String campo : campos) {
             String[] partes = campo.split(":", 2);
             if (partes.length == 2) {
                 String clave = partes[0].trim().replace("\"", "");
                 String valor = partes[1].trim().replace("\"", "");
                 persona.put(clave, valor);
             }
         }
         personas.add(persona);
     }

     return personas;
 }
}
