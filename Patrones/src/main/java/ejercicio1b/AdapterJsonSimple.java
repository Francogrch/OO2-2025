package ejercicio1b;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ejercicio1.VoorheesExporter;
import ejercicio1.Socio;

public class AdapterJsonSimple extends VoorheesExporter {
	private JSONObject adaptee;

	public AdapterJsonSimple() {
		adaptee = new JSONObject();
	}
	
	private JSONObject exportar(Socio socio) {
			adaptee.put("nombre",socio.getNombre());
			adaptee.put("email",socio.getEmail());
			adaptee.put("legajo",socio.getLegajo());
		return adaptee;
	}
	
	@Override
	public String exportar(List<Socio> socios) {
		JSONArray array = new JSONArray();
		for (Socio socio:socios) {
			array.add(exportar(socio));
		}
	
		return array.toJSONString();
			
	}
}
