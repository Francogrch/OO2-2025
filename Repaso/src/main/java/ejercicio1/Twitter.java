package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
	private List<Usuario> usuarios;
	public Twitter() {
		usuarios = new ArrayList<Usuario>();
	}
	private boolean yaRegistrado(String name) {
		return usuarios.stream().map(u -> u.getScreenName()).anyMatch(u -> u.equals(name));

	}
	public boolean agregarUsuario(String screenName) {
		return !yaRegistrado(screenName) && usuarios.add(new Usuario(screenName));
	}
	public boolean eliminarUsuario(Usuario user) {
		return usuarios.remove(user);
	}
}
