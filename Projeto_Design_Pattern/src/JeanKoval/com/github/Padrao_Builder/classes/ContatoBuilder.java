package JeanKoval.com.github.Padrao_Builder.classes;

import JeanKoval.com.github.Padrao_Builder.classes.interfaces.IContatoBuilder;

public class ContatoBuilder implements IContatoBuilder {
	
	private String descricao;
	private String celular;
	private String telefone;
	private String email;
	private Endereco endereco;
	private Empresa empresa;
	private Pessoa pessoa;

	public static ContatoBuilder builder() {
		return new ContatoBuilder();
	}
	
	public Contato gera() {
		return new Contato(descricao, celular, telefone, email, endereco, empresa, pessoa);
	}
    
	@Override
	public ContatoBuilder setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	@Override
	public ContatoBuilder setCelular(String celular) {
		this.celular = celular;
		return this;
	}

	@Override
	public ContatoBuilder setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

	@Override
	public ContatoBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public ContatoBuilder setEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}

	@Override
	public ContatoBuilder setEmpresa(Empresa empresa) {
		this.empresa = empresa;
		return this;
	}

	@Override
	public ContatoBuilder setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}
	
}
