package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String screenName;
	private int LIMITE = 257;
	private List<Tweet> tweets;
	public Usuario(String screenName) {
		this.screenName = screenName;
		tweets = new ArrayList<Tweet>();
	}
	
	public String getScreenName() {
		return screenName;
	}
	private boolean superaLimite(String text){
		long cant = text.chars().count();
		return 1 < cant && LIMITE < cant;
	}
	public boolean agregarTweet(String text) {
		return !superaLimite(text) && tweets.add(new Tweet(text));
	}
	public boolean eliminarTweet(Tweet tweet) {
		return tweets.remove(tweet);
	}
}
