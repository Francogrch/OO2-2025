package ejercicio2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Usuario {
	private String username;
	private List<Post> posts;

	public Usuario(String username) {
		this.username=username;
		posts = new ArrayList<Post>();
	}
	
	public List<Post> ultimosPosts(int cantidad){
		return posts.stream().sorted((p1,p2) -> p1.getFecha().compareTo(p2.getFecha())).limit(cantidad).collect(Collectors.toList());
	}
	
	
	
	

}
