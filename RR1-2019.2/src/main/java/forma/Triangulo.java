package forma;

public class Triangulo implements Forma{

	private int base;
	private int altura;
	
	public Triangulo(int base, int altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calculaArea() {
		double area = (this.base * this.altura) / 2;
		return area;
	}

}
