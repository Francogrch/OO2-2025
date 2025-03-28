package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Twitter {
	private List<Usuario> usuarios;
	public Twitter() {
		usuarios = new ArrayList<Usuario>();
	}
	private boolean yaRegistrado(String name) {
		return usuarios.stream().map(u -> u.getScreenName()).anyMatch(u -> u.equals(name));

	}
	public Usuario agregarUsuario(String screenName) {
		if (!yaRegistrado(screenName)) {
			Usuario user = new Usuario(screenName);
			usuarios.add(user);
			return user;
		}
		return null;
	}
	public boolean eliminarUsuario(Usuario user) {
		usuarios.stream().map(u -> u.limpiarRetweets(user)).collect(Collectors.toList());
		return usuarios.remove(user);
	}
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
}
