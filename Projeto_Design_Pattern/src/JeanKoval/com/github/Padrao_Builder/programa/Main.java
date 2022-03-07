package JeanKoval.com.github.Padrao_Builder.programa;

import JeanKoval.com.github.Padrao_Builder.classes.Contato;
import JeanKoval.com.github.Padrao_Builder.classes.ContatoBuilder;
import JeanKoval.com.github.Padrao_Builder.classes.Empresa;
import JeanKoval.com.github.Padrao_Builder.classes.Endereco;
import JeanKoval.com.github.Padrao_Builder.classes.Pessoa;

public class Main {

	public static void main(String[] args) {

		Endereco endereco = new Endereco("Rua Teste", "123", "Casa", "80001002", "Portao", "Curitiba", "Parana");
		Empresa  empresa  = new Empresa("Mercado Curitiba");
		Pessoa   pessoa   = new Pessoa("Jean", "Carlos");
		
		Contato contato = ContatoBuilder.builder()
							.setCelular("41999887766")
							.setDescricao("Contato 1")
							.setEmail("jean@teste.com")
							.setEndereco(endereco)
							.setTelefone("4133445566")
							.setEmpresa(empresa)
							.setPessoa(pessoa)
							.gera();
		
		System.out.println(contato);
	}

}
