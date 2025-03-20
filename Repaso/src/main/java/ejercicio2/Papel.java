package ejercicio2;

public class Papel implements Opcion{
	public Papel() {}
	
	public boolean play(Opcion opt) {
		return opt.jugarContraPapel();
	}
	public boolean jugarContraPiedra() {
		return true;
	}
	public boolean jugarContraTijera() {
		return false;
	}
	public boolean jugarContraPapel() {
		return null;
	}

}
