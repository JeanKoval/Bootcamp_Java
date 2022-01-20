package JeanKoval.com.github.classes;

public class ContaPoupanca extends Banco {
	
	public ContaPoupanca(Integer id, Double saldo, String conta, Cliente cliente) {
		super(id, saldo, conta, "P", cliente);
	}

}
