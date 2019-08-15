package forma;

public class main {

	public static void main(String[] args) {

		Quadrado q =  new Quadrado(5);
		Circulo c = new Circulo(5);
		Triangulo t = new Triangulo(5, 5);
		Retangulo r = new Retangulo(3, 9);
		
		System.out.println(q.calculaArea());
		System.out.println(c.calculaArea());
		System.out.println(t.calculaArea());
		System.out.println(r.calculaArea());
	}

}
