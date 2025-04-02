package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostApp {
	

	//private List<Usuario> usuarios;
	private List<Post> posts;
	
	
	public PostApp() {
		//usuarios = new ArrayList<Usuario>();
		posts = new ArrayList<Post>();
	}

	private List<Post> postsSinUser(Usuario user){
		return posts.stream().filter(p -> !p.getUsuario().equals(user)).collect(Collectors.toList());
	}
	
	private List<Post> ordenarFecha(List<Post> posts){
		return	posts.stream().sorted((p1,p2) -> p1.getFecha().compareTo(p2.getFecha())).collect(Collectors.toList());
	}
	
//	public List<Post> ultimosPosts(Usuario user, int cantidad){
//		return postsSinUser(user).stream().sorted((p1,p2) -> p1.getFecha().compareTo(p2.getFecha())).limit(cantidad).collect(Collectors.toList());
//	}
//	
	public List<Post> ultimosPosts(Usuario user, int cantidad){
		return ordenarFecha(postsSinUser(user)).stream().limit(cantidad).collect(Collectors.toList());
	}
	
//	private List<Post> ultimosPostsNoUsuario(Usuario user, int cant){
//		List<Post> ultimosPost = new ArrayList<Post>();
//		
//		for (Usuario user1:usuarios.stream().filter(u -> !u.equals(user)).collect(Collectors.toList())) {
//			ultimosPost.addAll(user1.ultimosPosts(cant));
//		};
//		return ultimosPost;
//
//	}
//	public List<Post> ultimosPosts(Usuario user,int cant){
//		
//		return ultimosPostsNoUsuario(user,cant).stream().sorted((p1,p2) -> p1.getFecha().compareTo(p2.getFecha())).limit(cant).collect(Collectors.toList());
//	}
// 
}
