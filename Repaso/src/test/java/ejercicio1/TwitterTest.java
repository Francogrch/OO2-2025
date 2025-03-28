package ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwitterTest {
	Twitter tw;
	Usuario user1,user2,user3;
	Tweet tw1,tw2,tw3;
	ReTweet rt1,rt2,rt3;
@BeforeEach
	void TwitterTest() {
		tw = new Twitter();
		user1 = tw.agregarUsuario("User1");
	user2 = tw.agregarUsuario("User2");
	user3 = tw.agregarUsuario("User3");
	tw1 = new Tweet("Text1");
	tw2 = new Tweet("Text2");
	tw3 = new Tweet("Text3");
    rt1 = new ReTweet(tw1);	
    rt2 = new ReTweet(tw1);	
   
    rt3 = new ReTweet(tw2);	
    
    user1.agregarPost(tw1);
    user1.agregarPost(tw3);
    
    user2.agregarPost(rt1);
    user3.agregarPost(rt2);
    
}
	@Test
	 void eliminarUsuarioTest() {
		tw.eliminarUsuario(user1);
		assertFalse(tw.getUsuarios().contains(user1));
		assertFalse(user2.getPosts().contains(rt1));
		assertFalse(user3.getPosts().contains(rt2));

	}

}
