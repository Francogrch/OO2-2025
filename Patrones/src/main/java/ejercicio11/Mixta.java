package ejercicio11;

import java.util.List;

public class Mixta extends Topografia{
	private List<Topografia> childs;
	
	public double getProporcion() {
	 return childs.stream().mapToDouble(t -> t.getProporcion()).sum() / childs.size();	
	}
	
	public Topografia add(Topografia t) {
		childs.add(t);
		return this;
	}
	public Topografia remove(Topografia t) {
		childs.remove(t);
		return this;
	}
	public List<Topografia> getChild(){
		return childs;
	}
	
	@Override
	public boolean igualdad(Object t) {
		Mixta otra = (Mixta) t;
		return childs.equals(otra.getChild());
	}

	

}
