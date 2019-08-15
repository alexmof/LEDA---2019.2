package forma;

public class Retangulo implements Forma{
	
	private double base;
	private double altura; 
	
	public Retangulo(int base, int altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calculaArea() {
		double area = base * altura;
		return area;
	}

	
}
