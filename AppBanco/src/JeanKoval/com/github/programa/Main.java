package JeanKoval.com.github.programa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

import JeanKoval.com.github.arquivos.Clientes;
import JeanKoval.com.github.arquivos.Contas;
import JeanKoval.com.github.arquivos.Enderecos;
import JeanKoval.com.github.classes.Banco;
import JeanKoval.com.github.classes.Cliente;
import JeanKoval.com.github.classes.ContaCorrente;
import JeanKoval.com.github.classes.ContaPoupanca;
import JeanKoval.com.github.classes.Endereco;
import JeanKoval.com.github.memoria.Memoria;

public class Main {
	
	public static Scanner sc 	   = new Scanner(System.in);
	public static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) throws IOException {
		
		Integer escolha = null;
		
		System.out.println("		BEM VINDO AO SEU APP DO BANCO DIGITAL		\n");
		
		do {
			System.out.println("Op��es dispon�veis:\n");
			System.out.println("  1 - Entrar em minha Conta;");
			System.out.println("  2 - Criar uma Conta;");
			System.out.println("  0 - Encerrar o programa;");
			System.out.print("\nDigite sua escolha: ");
			escolha = sc.nextInt();
			
			if(escolha>2)  
				System.out.println("\n\nN�o temos esta op��o no momento, tente novamente!\n\n");
			else if(escolha==1)
				login();
			else if(escolha==2)
				criarConta();
		}while(escolha!=0);
		
		System.out.println("\nPrograma Encerrado!");
		sc.close();
	}
	
	public static void acoesAreaLogada() throws IOException {
		Integer escolha = 0;
		do {
			System.out.println("Temos as seguintes op��es para sua conta:\n");
			System.out.println("  1 - Saque;");
			System.out.println("  2 - Dep�sito;");
			System.out.println("  3 - Tranfer�ncia;");
			System.out.println("  0 - Sair da Conta;");
			System.out.print("\nDigite a sua escolha: ");
			escolha = sc.nextInt();
			
			//atualiza as informa��es da conta, para atualizar o saldo
			Memoria.setContaLogada(Memoria.contaAtual.getId(), Memoria.contaAtual.getCliente().getId(), Memoria.contaAtual.getTipoConta(), false);

			switch(escolha) {
				case 0: break;
				case 1: saque(); break;
				case 2: deposito(); break;
				case 3: transferencia(); break;
				default:
					System.out.println("\nN�o temos essa op��o no momento, tente novamente!\n");					
			}
		}while(escolha!=0);
		pularLinha();
	}
	
	public static void saque() throws IOException {
		Double saldoAutal = Memoria.contaAtual.getSaldo();
		
		if(saldoAutal==0) {
			System.out.println("\nSeu saldo est� zerado, fa�a uma dep�sito para obter saldo!\n");
			return;
		}
		
		System.out.println("\nSeu saldo atual � de " + df.format(saldoAutal));
		System.out.print("\nDigite o valor que deseja sacar: ");
		Double valorSaque = sc.nextDouble();
		
		if(valorSaque > saldoAutal) {
			System.out.println("\nValor insuficiente na conta para saque!");
			return;
		}
		
		Contas.execSaque(Memoria.contaAtual.getId(), valorSaque, "saque");
		
		System.out.println("\nSaque efetuado com Sucesso!\n");
	}
	
	public static void deposito() throws IOException {
		System.out.print("\nDigite o valor que deseja depositar: ");
		Double valorDeposito = sc.nextDouble();
		
		Contas.execSaque(Memoria.contaAtual.getId(), valorDeposito, "deposito");
		
		System.out.println("\nDeposito efetuado com Sucesso!\n");
	}
	
	public static void transferencia() throws IOException {
		Double saldoAutal = Memoria.contaAtual.getSaldo();
		
		if(saldoAutal==0) {
			System.out.println("\nSeu saldo est� zerado, fa�a uma dep�sito para obter saldo!\n");
			return;
		}
		
		System.out.println("\nSeu saldo atual � de " + df.format(saldoAutal));
		
		System.out.println("\nExemplo: (0001-1)");
		System.out.print("Digite a conta para qual quer tranferir: ");
		String contaDestino = sc.next();
		Integer idDestino   = Contas.getIdByConta(contaDestino);
		
		if(Memoria.contaAtual.getId()==idDestino) {
			System.out.println("\nEsta conta digitada � a sua, escolha outra conta para Transferencia!\n");
			return;
		}
		
		if(idDestino == null) {
			System.out.println("\nN�mero de Conta n�o encontrada, tente novamente!\n");
			return;
		}
		
		System.out.print("Digite o valor que deseja tranferir: ");
		Double valorTrans = sc.nextDouble();
		
		if(valorTrans > saldoAutal) {
			System.out.println("\nValor insuficiente na conta para tranferencia!");
			return;
		}
		
		Contas.execTranferencia(Memoria.contaAtual.getId(), idDestino, valorTrans);
		
		System.out.println("\nTranferencia efetuada com Sucesso!\n");
	}
	
	public static void login() throws IOException {
		System.out.println("\nPARA CONECTAR EM SUA CONTA PRECISAMOS DAS SEGUINTES INFORMA��ES: ");
		System.out.print("\nDigite seu CPF: ");
		String cpf = sc.next();
		
		if(Clientes.validaCPFDuplicado(cpf)) {
			System.out.println("\nCPF n�o encontrado na base de dados!\n");
			return;
		}
		
		System.out.println("Exemplo: (0001-1)");
		System.out.print("Digite o n�mero da sua conta com o digito: ");
		String conta = sc.next();
		System.out.println("C - Conta Corrente | P - Conta Poupan�a");
		System.out.print("Digite o tipo da sua Conta: ");
		String tipoConta = sc.next();
		if(!(tipoConta!="C" || tipoConta!="P")) {
			System.out.println("\nTipo de conta inexistente, tente novamente!");
			return;
		}
		Integer idConta = Contas.getIdClienteByContaAndType(conta, tipoConta); 
		if(idConta==-1) {
			System.out.println("\nN�o encontramos a conta informada, tente novamente!\n");
			return;
		}
		Integer idCliente = Clientes.getIdByCPF(cpf);
		if(idConta!=idCliente) {
			System.out.println("\nA conta informada n�o est� cadastrada no CPF informado, tente novamente!\n");
			return;
		}
		
		Memoria.setContaLogada(idConta, idCliente, tipoConta, true);
		acoesAreaLogada();
	}
	
	public static void criarConta() throws IOException {
		pularLinha();
		System.out.println("---------------------------------------------------");
		System.out.println("----------------- Cria��o de Conta ----------------");
		System.out.println("---------------------------------------------------");
		pularLinha();
		
		Integer escolha = escolhaConta(), numero;
		String nome, sobrenome, cpf, telefone, email, rua, cidade, estado;
		
		pularLinha();
		System.out.println("---------------------------------------------------");
		System.out.println("------- Informa��es Pessoais da Nova Conta: -------");
		System.out.println("---------------------------------------------------");
		pularLinha();
		
		System.out.print("Digite seu Nome: ");
		nome = sc.next();
		System.out.print("Digite seu Sobrenome: ");
		sobrenome = sc.next();
		System.out.print("Digite seu CPF: ");
		cpf = sc.next();
		cpf = validaCPF(cpf);
		System.out.print("Digite seu Telefone: ");
		telefone = sc.next();
		telefone = validaTelefone(telefone);
		System.out.print("Digite seu E-mail: ");
		email = sc.next();
		
		pularLinha();
		System.out.println("---------------------------------------------------");
		System.out.println("----- Informa��es de Endere�o da Nova Conta: ------");
		System.out.println("---------------------------------------------------");
		pularLinha();
		
		System.out.print("Digite sua Rua: ");
		rua = sc.next();
		System.out.print("Digite seu Numero: ");
		numero = sc.nextInt();
		System.out.print("Digite sua Cidade: ");
		cidade = sc.next();
		System.out.print("Digite seu Estado: ");
		estado = sc.next();
		
		Endereco ende 	 = new Endereco(Enderecos.getNewId() , rua, numero, cidade, estado);
		Enderecos.writeEndereco(ende);

		Cliente  cliente = new Cliente(Clientes.getNewId(), nome, sobrenome, cpf, telefone, email, ende);
		Clientes.writeCliente(cliente);
		
		Banco conta = ( escolha==1 ? new ContaCorrente() : new ContaPoupanca() );
		conta.setId(Contas.getNewId());
		conta.setAgencia("001");
		conta.setConta(Contas.getNewConta());
		conta.setSaldo(0.00d);
		conta.setTipoConta( (escolha==1 ? "C" : "P") );
		conta.setCliente(cliente);
		Contas.writeConta(conta);
		
		pularLinha();
		System.out.println("!!! CONTA CRIDA COM SUCESSO !!!");
		System.out.println("!!! Agencia: "+conta.getAgencia()+" Conta: "+conta.getConta()+" !!!\n");
		
		Memoria.contaAtual 	   = conta;
		Memoria.tipoContaAtual = conta.getTipoConta();
		Memoria.msgBemVindo();
		acoesAreaLogada();
	}
	
	public static Integer escolhaConta() {
		Integer escolha=0;
		
		do {
			System.out.println("Op��es de Contas Disponiv�is:\n");
			System.out.println("  1 - Conta Corrente;");
			System.out.println("  2 - Conta Poupan�a;");
			System.out.print("\nQual sua escolha: ");
			escolha = sc.nextInt();
			
			if(escolha!=1 && escolha!=2) {
				pularLinha();
				System.out.println("---------------------------------------------------");
				System.out.println("N�o temos a op��o digitada, tescolha uma de nossas op��es!");
				pularLinha();
			}
		}while(escolha!=1 && escolha!=2);
		return escolha;
	}
	
	public static String validaCPF(String cpf) throws FileNotFoundException {
		if(cpf.length() != 11) {
			do{
				pularLinha();
				System.out.println("CPF deve conter 11 digitos!!");
				pularLinha();
				System.out.print("Digite o CPF novamente: ");
				cpf = sc.next();
			}while(cpf.length()!=11);
		}
		if(!Clientes.validaCPFDuplicado(cpf)) {
			do{
				pularLinha();
				System.out.println("CPF j� cadastrado na base de dados!!");
				pularLinha();
				System.out.print("Digite o CPF novamente: ");
				cpf = sc.next();
			}while(Clientes.validaCPFDuplicado(cpf) == false);
		}
		return cpf;
	}
	
	public static String validaTelefone(String telefone) {
		if(telefone.length() < 8 || telefone.length() > 11) {
			do{
				pularLinha();
				System.out.println("Telefone deve ter no minimo 8 e no maximo 11 digitos!!");
				System.out.print("Digite o Telefone novamente: ");
				telefone = sc.next();
			}while(telefone.length() < 8 || telefone.length() > 11);
		}
		
		return telefone;
	}
	
	public static void pularLinha() {
		System.out.println("");
	}

}
