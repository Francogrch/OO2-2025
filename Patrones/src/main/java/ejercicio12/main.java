package ejercicio12;

public class main {

	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		Carpeta raiz = fs.getRaiz();
		raiz.addChild(new Archivo("a1"));
		raiz.addChild(new Archivo("a2"));
		Carpeta d2 = new Carpeta("d2");
		d2.addChild(new Archivo("a3"));
		d2.addChild(new Archivo("a4"));
		raiz.addChild(d2);
		System.out.println(raiz.buscar("a2").toString());
		
	}

}
