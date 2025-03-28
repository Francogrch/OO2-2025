package ejercicio1;

public class Tweet implements Post{
	private String text;
	
	public Tweet(String text) {
		this.text = text;
	}
	
	public boolean reTweet(Usuario user) {
		return user.agregarPost(new ReTweet(this));
	}
	public Post getOrigen() {
		return null; 
	}
}
