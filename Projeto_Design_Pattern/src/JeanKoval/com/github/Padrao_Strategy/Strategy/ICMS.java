package JeanKoval.com.github.Padrao_Strategy.Strategy;

public class ICMS implements Imposto{

	private Double valor;
	
	
	public ICMS(Double valor) {
		this.valor = valor;
	}


	@Override
	public double calcular() {
		return this.valor * 0.10;
	}

}
