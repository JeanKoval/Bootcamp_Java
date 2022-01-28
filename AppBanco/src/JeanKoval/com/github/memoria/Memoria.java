package JeanKoval.com.github.memoria;

import java.io.FileNotFoundException;

import JeanKoval.com.github.arquivos.Clientes;
import JeanKoval.com.github.arquivos.Contas;
import JeanKoval.com.github.arquivos.Enderecos;
import JeanKoval.com.github.classes.Banco;
import JeanKoval.com.github.classes.Cliente;
import JeanKoval.com.github.classes.ContaCorrente;
import JeanKoval.com.github.classes.ContaPoupanca;
import JeanKoval.com.github.classes.Endereco;

public class Memoria {
	
	public static Banco contaAtual;
	public static String tipoContaAtual;
	
	public static void setContaLogada(Integer idConta, Integer idCliente, String tipoConta, Boolean login) throws FileNotFoundException {
		
		tipoContaAtual = tipoConta;
		
		String[] dadosCliente  = Clientes.getClienteById(idCliente);
		String[] dadosConta    = Contas.getContaById(idConta);
		String[] dadosEndereco = Enderecos.getEnderecoById(Integer.parseInt(dadosCliente[6]));
		tipoContaAtual		   = dadosConta[5];
		
		Endereco ende   = new Endereco(Integer.parseInt(dadosEndereco[0]), dadosEndereco[1], Integer.parseInt(dadosEndereco[2]), dadosEndereco[3], dadosEndereco[4]);
		Cliente cliente = new Cliente(Integer.parseInt(dadosCliente[0]), dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4], dadosCliente[5], ende);
		
		contaAtual = tipoContaAtual.equals("C") ? new ContaCorrente() : new ContaPoupanca();
		contaAtual.setId(Integer.parseInt(dadosConta[0]));
		contaAtual.setSaldo(Double.parseDouble(dadosConta[1].replaceAll(",", ".")));
		contaAtual.setAgencia(dadosConta[2]);
		contaAtual.setConta(dadosConta[4]);
		contaAtual.setCliente(cliente);
		
		if(login)
			msgBemVindo();
	}
	
	public static void msgBemVindo() {
		if(tipoContaAtual.equals("C"))
			System.out.println("\nSeja Bem-Vindo a sua Conta Corrente " + contaAtual.getCliente().getNomeInteiro() +"\n");			
		else
			System.out.println("\nSeja Bem-Vindo a sua Conta Poupança " + contaAtual.getCliente().getNomeInteiro() +"\n");
	}
}
