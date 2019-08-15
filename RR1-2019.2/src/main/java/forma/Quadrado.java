package forma;

public class Quadrado implements Forma{
	private double lado;

	public Quadrado(double lado) {
		super();
		this.lado = lado;
	}

	@Override
	public double calculaArea() {
		double area = this.lado * this.lado;
		return area;
	}
	
}
