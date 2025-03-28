package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
	private String screenName;
	private int LIMITE = 257;
	private List<Post> posts;

	public Usuario(String screenName) {
		this.screenName = screenName;
		posts = new ArrayList<Post>();
	}
	
	public String getScreenName() {
		return screenName;
	}
	public List<Post> getPosts(){
		return posts;
	}
	private boolean superaLimite(String text){
		long cant = text.chars().count();
		return 1 < cant && LIMITE < cant;
	}
	public boolean agregarTweet(String text) {
		return !superaLimite(text) && agregarPost(new Tweet(text));
	}
	public boolean agregarPost(Post post) {
		return posts.add(post);
	}
	public boolean tengoPostOrigen(Post post) {
		return posts.contains(post.getOrigen());
	}
	
	public boolean limpiarRetweets(Usuario user) {
		List<Post> remove = posts.stream().filter(p -> user.tengoPostOrigen(p)).collect(Collectors.toList());
		return posts.removeAll(remove);
	}
	}
