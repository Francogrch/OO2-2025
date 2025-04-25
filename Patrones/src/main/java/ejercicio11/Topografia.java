package ejercicio11;

public abstract class  Topografia {

	public abstract double getProporcion();
	
	public Topografia add(Topografia t) {
		Mixta mixta = new Mixta();
		mixta.add(this);
		return mixta;
	}
	public Topografia remove(Topografia t) {
		Mixta mixta = new Mixta();
		mixta.remove(this);
		return mixta;
	}

	//No puedo implementar el getChild
	
	public boolean igualdad(Object t) {
		return this.getClass() == t.getClass();
	}
	
	@Override
	public boolean equals(Object otra) {
		if (otra == null || getClass() != otra.getClass()) {
			return false;
		} else {
			return this.igualdad(otra);
		}
	}
	
}
