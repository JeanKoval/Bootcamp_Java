package JeanKoval.com.github.Padrao_Strategy.Strategy;

public class IPI implements Imposto{

	private Double valor;
	
	
	public IPI(Double valor) {
		this.valor = valor;
	}


	@Override
	public double calcular() {
		return this.valor * 0.20;
	}

}
