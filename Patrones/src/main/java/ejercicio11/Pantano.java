package ejercicio11;

public class Pantano extends Topografia{
	private Mixta mixta;
	public Pantano() {
		mixta = new Mixta();
		Agua agua = new Agua();
		Tierra tierra = new Tierra();
		mixta.add(agua);
		mixta.add(agua);
		mixta.add(tierra);
	}
	public double getProporcion() {
		return mixta.getProporcion();
	}
	
}
