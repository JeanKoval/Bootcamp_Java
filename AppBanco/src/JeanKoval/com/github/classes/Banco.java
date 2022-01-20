package JeanKoval.com.github.classes;

abstract public class Banco {
	protected Integer id;
	protected Double  saldo;
	protected String agencia;
	protected String conta;
	protected String  tipoConta;
	protected Cliente cliente;

	public Banco(Integer id, Double saldo, String conta, String tipoConta, Cliente cliente) {
		setId(id);
		setSaldo(saldo);
		setAgencia("001");
		setConta(conta);
		setTipoConta(tipoConta);
		setCliente(cliente);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
