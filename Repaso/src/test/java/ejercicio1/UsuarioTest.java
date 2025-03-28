package ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	public Usuario user1,user2,user3;
	public Tweet tw1,tw2,tw3;
	public int LIMITE = 257;
	
 @BeforeEach
 public void UsuarioTest() {
	 user1 = new Usuario("user1");
	 user2 = new Usuario("user2");
	 user3 = new Usuario("user3");
	 tw1 = new Tweet("Texto");
	 tw2 = new Tweet("Texto");
	 tw3 = new Tweet("Texto");

 }
 @Test
 void agregarTweet() {
	 
	 String textoMin = "A".repeat(LIMITE);
	 String textoMax = "B".repeat(LIMITE+1);

	 assertTrue( user1.agregarTweet(textoMin));
	 assertFalse( user1.agregarTweet(textoMax))	;
	 
 }
	@Test
	void agregarPostTest() {
		user1.agregarPost(tw1);
		assertTrue(user1.getPosts().contains(tw1));
	}
	
	@Test
	void tengoPostOrigenTest() {
		user1.agregarPost(tw1);
		user1.agregarPost(tw2);
		ReTweet rt2 = new ReTweet(tw2);
		user2.agregarPost(rt2);
		assertTrue(user1.tengoPostOrigen(rt2));
	}
	
	@Test
	void limpiarRetweets() {
		user1.agregarPost(tw1);
		user1.agregarPost(tw2);
		ReTweet rt2 = new ReTweet(tw2);
		user2.agregarPost(rt2);
		user3.agregarPost(rt2);
		ReTweet rt3 = new ReTweet(rt2);
		user2.limpiarRetweets(user1);
        assertFalse(user2.getPosts().contains(rt2)); 
        user3.limpiarRetweets(user1);
        assertFalse(user3.getPosts().contains(rt3)); 
	}

}
