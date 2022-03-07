package JeanKoval.com.github.Padrao_Builder.classes.interfaces;

import JeanKoval.com.github.Padrao_Builder.classes.ContatoBuilder;
import JeanKoval.com.github.Padrao_Builder.classes.Empresa;
import JeanKoval.com.github.Padrao_Builder.classes.Endereco;
import JeanKoval.com.github.Padrao_Builder.classes.Pessoa;

public interface IContatoBuilder {
	
	public ContatoBuilder setDescricao(String descricao);
	public ContatoBuilder setCelular(String celular);
	public ContatoBuilder setTelefone(String telefone);
	public ContatoBuilder setEmail(String email);;
	public ContatoBuilder setEndereco(Endereco endereco);
	public ContatoBuilder setEmpresa(Empresa empresa);
	public ContatoBuilder setPessoa(Pessoa pessoa);
	
}
