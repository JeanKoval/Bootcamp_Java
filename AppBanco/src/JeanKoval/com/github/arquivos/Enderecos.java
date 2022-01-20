package JeanKoval.com.github.arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import JeanKoval.com.github.classes.Endereco;

public class Enderecos {
	private static String nameArq = "Enderecos.csv";
	
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
	
	public static String[] getEnderecoById(Integer id) throws FileNotFoundException {
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				String ende[] = scan.nextLine().split(";");
				if(Integer.parseInt(ende[0])==id)
					return ende;
			}
			scan.close();
		}
		return null;
	}
	
	public static String readAllEnderecos() throws IOException {
		String enderecos="";
		File file = new File(nameArq);
		if (file.exists()) {
			Scanner scan = new Scanner(new File(nameArq));
			while(scan.hasNext()) {
				enderecos+= scan.nextLine()+"\n";
			}
			scan.close();
		}
		return enderecos;
	}
	
	public static void writeEndereco(Endereco ende) throws IOException {
		String enderecos = readAllEnderecos();
		FileWriter writer = new FileWriter(new File(nameArq));
		writer.write(enderecos);
		writer.write(ende.getId()+";"+ende.getRua()+";"+ende.getNumero()+";"+ende.getCidade()+";"+ende.getEstado()+"\n");
		writer.close();
	}
}
