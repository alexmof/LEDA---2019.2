package forma;

public class Circulo implements Forma{
	
	private double raio;

	public Circulo(double raio) {
		super();
		this.raio = raio;
	}

	@Override
	public double calculaArea() {
		double area = Math.pow(this.raio, Math.PI);
		return area;
	}
	

}
