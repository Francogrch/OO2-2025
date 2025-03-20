package ejercicio1;
import java.util.List;
import java.util.ArrayList;

public class Tweet {
	private String text;
	private List<ReTweet> reTweets;
	
	
	public Tweet(String text) {
		reTweets = new ArrayList<ReTweet>();
		this.text = text;
	}
	
	public void eliminar() {
		reTweets.clear();
	}
	
	public boolean reTweet() {
		return reTweets.add(new ReTweet(this));
	}
	public int sizeReTweet() {
		return reTweets.size();
	}
}
