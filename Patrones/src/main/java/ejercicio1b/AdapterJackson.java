package ejercicio1b;
import ejercicio1.VoorheesExporter;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ejercicio1.Socio;

public class AdapterJackson extends VoorheesExporter {
	private ObjectMapper adaptee;

	public AdapterJackson() {
		adaptee = new ObjectMapper();
	}
	
	private String exportar(Socio socio) throws JsonProcessingException {
		return adaptee.writeValueAsString(socio);
	}
	
	@Override
	public String exportar(List<Socio> socios) {
		String text = "[";
		for (Socio socio:socios) {
			try {
				text = text.concat(exportar(socio));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			text = text.concat(",");
		}
		text = text.concat("]");
	
		return text; 
	}
}