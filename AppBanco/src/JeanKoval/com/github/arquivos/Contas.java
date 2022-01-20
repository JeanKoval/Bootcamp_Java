package JeanKoval.com.github.arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import JeanKoval.com.github.classes.Banco;

public class Contas {
	private static String nameArq   = "Contas.csv";
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	public static Integer getNewId() throws FileNotFoundException {
		Integer id = 0;
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String conta[] = scan.nextLine().split(";");
				id = Integer.parseInt(conta[0]);
			}
			scan.close();
		}
		return ++id;
	}
	
	public static String getNewConta() throws FileNotFoundException {
		String c = "0001-0";
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String conta[] = scan.nextLine().split(";");
				c = conta[3];
			}
			scan.close();
		}
		String dados[] = c.split("-");
		if(dados[1].equals("9")) 
			c = (Integer.parseInt(dados[0])+1) + "-1";
		else
			c = dados[0] + "-" + (Integer.parseInt(dados[1])+1);
		return c;			
	}
	
	public static Integer getIdClienteByContaAndType(String conta, String tipoConta) throws FileNotFoundException {
		Integer id = -1;
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String c[] = scan.nextLine().split(";");
				if(c[3].equals(conta) && c[4].equals(tipoConta))
					return Integer.parseInt(c[0]);
			}
			scan.close();
		}
		return id;
	}
	
	public static String[] getContaById(Integer id) throws FileNotFoundException {
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String conta[] = scan.nextLine().split(";");
				if(Integer.parseInt(conta[0])==id)
					return conta;
			}
			scan.close();
		}
		return null;
	}
	
	public static Integer getIdByConta(String conta1) throws FileNotFoundException {
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String conta[] = scan.nextLine().split(";");
				if(conta[3].equals(conta1))
					return Integer.parseInt(conta[0]);
			}
			scan.close();
		}
		return null;
	}
	
	public static void execSaque(Integer idConta, Double valor, String tipo) throws IOException {
		String contas="";
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String[] conta = scan.nextLine().split(";");
				if(Integer.parseInt(conta[0]) == idConta)
					if(tipo == "saque")
						conta[1] = df.format(Double.parseDouble(conta[1].replaceAll(",", "."))-valor);
					else
						conta[1] = df.format(Double.parseDouble(conta[1].replaceAll(",", "."))+valor);
				contas+= String.join(";", conta) +"\n";
			}
			scan.close();
		}
		FileWriter writer = new FileWriter(new File(nameArq));
		writer.write(contas);
		writer.close();
	}
	
	public static void execTranferencia(Integer idConta, Integer idDestino, Double valor) throws IOException {
		String contas="";
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String[] conta = scan.nextLine().split(";");
				if(Integer.parseInt(conta[0]) == idConta)
					conta[1] = df.format(Double.parseDouble(conta[1].replaceAll(",", "."))-valor);
				if(Integer.parseInt(conta[0]) == idDestino)
					conta[1] = df.format(Double.parseDouble(conta[1].replaceAll(",", "."))+valor);
				contas+= String.join(";", conta) +"\n";
			}
			scan.close();
		}
		FileWriter writer = new FileWriter(new File(nameArq));
		writer.write(contas);
		writer.close();
	}
	
	public static String readAllContas() throws IOException {
		String contas="";
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				contas+= scan.nextLine()+"\n";
			}
			scan.close();
		}
		return contas;
	}
	
	public static void writeConta(Banco conta) throws IOException {
		String contas = readAllContas();
		FileWriter writer = new FileWriter(new File(nameArq));
		writer.write(contas);
		writer.write(conta.getId()+";"+conta.getSaldo()+";"+conta.getAgencia()+";"+conta.getConta()+";"+conta.getTipoConta()+";"+conta.getCliente().getId()+"\n");
		writer.close();
	}
}
