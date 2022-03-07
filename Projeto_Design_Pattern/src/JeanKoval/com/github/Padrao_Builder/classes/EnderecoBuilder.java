package JeanKoval.com.github.Padrao_Builder.classes;

import JeanKoval.com.github.Padrao_Builder.classes.interfaces.IEnderecoBuilder;

public class EnderecoBuilder implements IEnderecoBuilder {

	private String rua;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	
	public static EnderecoBuilder builder() {
		return new EnderecoBuilder();
	}
	
	public Endereco gera() {
		return new Endereco(rua, numero, complemento, cep, bairro, cidade, estado);
	}
	
	@Override
	public EnderecoBuilder setRua(String rua) {
		this.rua = rua;
		return this;
	}

	@Override
	public EnderecoBuilder setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	@Override
	public EnderecoBuilder setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	@Override
	public EnderecoBuilder setCep(String cep) {
		this.cep = cep;
		return this;
	}

	@Override
	public EnderecoBuilder setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	@Override
	public EnderecoBuilder setCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	@Override
	public EnderecoBuilder setEstado(String estado) {
		this.estado = estado;
		return this;
	}

}
