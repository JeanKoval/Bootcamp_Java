package JeanKoval.com.github.classes;

public class Cliente {
	
	private Integer  id;
	private String   nome;
	private String   sobrenome;
	private String   cpf;
	private String   telefone;
	private String   email;
	private Endereco endereco;
	
	public Cliente(Integer id, String nome, String sobrenome, String cpf, String telefone, String email, Endereco endereco) {
		setId(id);
		setNome(nome);
		setSobrenome(sobrenome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		setEndereco(endereco);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}
	
	public String getNomeInteiro() {
		return this.nome + " " + this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
