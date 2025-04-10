package ejercicio3;

public class AdapterVideoStream extends Media{
	private VideoStream adaptee;
	
	@Override
	public void play() {
		adaptee.reproduce();
	}
}
