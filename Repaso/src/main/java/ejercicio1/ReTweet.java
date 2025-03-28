package ejercicio1;

public class ReTweet implements Post{
	private	Post origen;
	
	public ReTweet(Post origen) {
		this.origen = origen;
	}
	public Post getOrigen() {
		if (origen.getOrigen() == null) {
		return origen;
	}
		return origen.getOrigen();
	}	
}
