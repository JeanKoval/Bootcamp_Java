package JeanKoval.com.github.Padrao_Builder.classes;

public class Contato {
	
	private String descricao;
	private String celular;
	private String telefone;
	private String email;
	private Endereco endereco;
	private Empresa empresa;
	private Pessoa pessoa;
	
	public Contato(String descricao, String celular, String telefone, String email, Endereco endereco, Empresa empresa,
			Pessoa pessoa) {
		super();
		this.descricao = descricao;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.empresa = empresa;
		this.pessoa = pessoa;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Descrição: "+getDescricao());
		return sb.toString();
	}
	
}
