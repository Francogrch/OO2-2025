package ejercicio2;

public class Piedra implements Opcion{
	public Piedra() {}
	
	public boolean play(Opcion opt) {
		return opt.jugarContraPiedra();
	}
	public boolean jugarContraPiedra() {
		return null;
	}
	public boolean jugarContraTijera() {
		return false;
	}
	public boolean jugarContraPapel() {
		return true;
	}

}
