package ejercicio3;

public class AdapterVideoStream implements Media{

	private VideoStream adaptee;
	
	@Override
	public void play() {
		adaptee.reproduce();
	}
}
