package JeanKoval.com.github.arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import JeanKoval.com.github.classes.Cliente;


public class Clientes {
	private static String nameArq = "Clientes.csv";
	
	public static Integer getNewId() throws FileNotFoundException {
		Integer id = 0;
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String cliente[] = scan.nextLine().split(";");
				id = Integer.parseInt(cliente[0]);
			}
			scan.close();
		}
		return ++id;
	}
	
	public static Integer getIdByCPF(String cpf) throws FileNotFoundException {
		Integer id = -1;
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String cliente[] = scan.nextLine().split(";");
				if(cliente[3].equals(cpf))
					return Integer.parseInt(cliente[0]);
			}
			scan.close();
		}
		return id;
	}
	
	public static String[] getClienteById(Integer id) throws FileNotFoundException {
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String cliente[] = scan.nextLine().split(";");
				if(Integer.parseInt(cliente[0])==id)
					return cliente;
			}
			scan.close();
		}
		return null;
	}
	
	public static String readAllClientes() throws IOException {
		String clientes="";
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				clientes+= scan.nextLine()+"\n";
			}
			scan.close();
		}
		return clientes;
	}
	
	public static void writeCliente(Cliente cliente) throws IOException {
		String clientes = readAllClientes();
		FileWriter writer = new FileWriter(new File(nameArq));
		writer.write(clientes);
		writer.write(cliente.getId()+";"+cliente.getNome()+";"+cliente.getSobrenome()+";"+cliente.getCpf()+";"+cliente.getTelefone()+";"+cliente.getEmail()+";"+cliente.getEndereco().getId()+"\n");
		writer.close();
	}
	
	public static Boolean validaCPFDuplicado(String cpf) throws FileNotFoundException {
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String cliente[] = scan.nextLine().split(";");
				if(cliente[3].equals(cpf))
					return false;
			}
			scan.close();
		}
		return true;
	}
}
