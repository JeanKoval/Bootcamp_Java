package JeanKoval.com.github.memoria;

import java.io.FileNotFoundException;

import JeanKoval.com.github.arquivos.Clientes;
import JeanKoval.com.github.arquivos.Contas;
import JeanKoval.com.github.arquivos.Enderecos;
import JeanKoval.com.github.classes.Cliente;
import JeanKoval.com.github.classes.ContaCorrente;
import JeanKoval.com.github.classes.ContaPoupanca;
import JeanKoval.com.github.classes.Endereco;

public class Memoria {
	
	public static ContaCorrente contaCAtual;
	public static ContaPoupanca contaPAtual;
	public static String tipoContaAtual;
	
	public static void setContaLogada(Integer idConta, Integer idCliente, String tipoConta, Boolean login) throws FileNotFoundException {
		
		tipoContaAtual = tipoConta;
		
		String[] dadosCliente  = Clientes.getClienteById(idCliente);
		String[] dadosConta    = Contas.getContaById(idConta);
		String[] dadosEndereco = Enderecos.getEnderecoById(Integer.parseInt(dadosCliente[6]));
		
		Endereco ende   = new Endereco(Integer.parseInt(dadosEndereco[0]), dadosEndereco[1], Integer.parseInt(dadosEndereco[2]), dadosEndereco[3], dadosEndereco[4]);
		Cliente cliente = new Cliente(Integer.parseInt(dadosCliente[0]), dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4], dadosCliente[5], ende);
		
		if(tipoContaAtual.equals("C"))
			contaCAtual = new ContaCorrente(Integer.parseInt(dadosConta[0]), Double.parseDouble(dadosConta[1].replaceAll(",", ".")), dadosConta[4], cliente);
		else
			contaPAtual = new ContaPoupanca(Integer.parseInt(dadosConta[0]), Double.parseDouble(dadosConta[1].replaceAll(",", ".")), dadosConta[4], cliente);
		
		if(login)
			msgBemVindo();
	}
	
	public static void msgBemVindo() {
		if(tipoContaAtual.equals("C"))
			System.out.println("\nSeja Bem-Vindo a sua Conta Corrente " + contaCAtual.getCliente().getNomeInteiro() +"\n");			
		else
			System.out.println("\nSeja Bem-Vindo a sua Conta Poupança " + contaPAtual.getCliente().getNomeInteiro() +"\n");
	}
}
