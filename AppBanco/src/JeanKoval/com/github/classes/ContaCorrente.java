package JeanKoval.com.github.classes;

public class ContaCorrente extends Banco {

	public ContaCorrente(Integer id, Double saldo, String conta, Cliente cliente) {
		super(id, saldo, conta, "C", cliente);
	}
}
