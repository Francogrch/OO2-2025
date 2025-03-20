package ejercicio2;

public class Tijera implements Opcion{
	public Tijera() {}
	
	public boolean play(Opcion opt) {
		return opt.jugarContraTijera();
	}
	public boolean jugarContraPiedra() {
		return false;
	}
	public boolean jugarContraTijera() {
		return null;
	}
	public boolean jugarContraPapel() {
		return true;
	}

}

