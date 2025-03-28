package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostApp {
	

	private List<Usuario> usuarios;
 
	public PostApp() {
		usuarios = new ArrayList<Usuario>();
	}
	
	private List<Post> ultimosPostsNoUsuario(Usuario user, int cant){
		List<Post> ultimosPost = new ArrayList<Post>();
		
		for (Usuario user1:usuarios.stream().filter(u -> u.equals(user)).collect(Collectors.toList())) {
			ultimosPost.addAll(user1.ultimosPosts(cant));
		};
		return ultimosPost;

	}
	public List<Post> ultimosPosts(Usuario user,int cant){
		
		return ultimosPostsNoUsuario(user,cant).stream().sorted((p1,p2) -> p1.getFecha().compareTo(p2.getFecha())).limit(cant).collect(Collectors.toList());
	}
 
}
