package JeanKoval.com.github.Padrao_Builder.classes.interfaces;

import JeanKoval.com.github.Padrao_Builder.classes.EnderecoBuilder;

public interface IEnderecoBuilder {

	public EnderecoBuilder setRua(String rua);
	public EnderecoBuilder setNumero(String numero);
	public EnderecoBuilder setComplemento(String complemento);
	public EnderecoBuilder setCep(String cep);
	public EnderecoBuilder setBairro(String bairro);
	public EnderecoBuilder setCidade(String cidade);
	public EnderecoBuilder setEstado(String estado);
	
}
