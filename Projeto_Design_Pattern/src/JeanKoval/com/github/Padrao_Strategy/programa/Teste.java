package JeanKoval.com.github.Padrao_Strategy.programa;

import JeanKoval.com.github.Padrao_Strategy.Problema.CalculadoraDeImpostos;
import JeanKoval.com.github.Padrao_Strategy.Strategy.CalculadoraDeImposto;
import JeanKoval.com.github.Padrao_Strategy.Strategy.ICMS;
import JeanKoval.com.github.Padrao_Strategy.Strategy.IPI;

public class Teste {

	public static void main(String[] args) {
		
		// Exemplo sem Utilizar Design Pattern
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		System.out.println("ICMS: " + calculadora.calcular("ICMS", 100d));
		System.out.println("IPI: " + calculadora.calcular("IPI", 100d));
		System.out.println("OUTRO: " + calculadora.calcular("NOVO_IMPOSTO", 100d));
		
		// Exempli Utilizando Design Pattern - Strategy
		CalculadoraDeImposto calculadora1 = new CalculadoraDeImposto();
		ICMS icms = new ICMS(100.0); 
	    IPI ipi = new IPI(100.0); 
	    System.out.println("ICMS: " + calculadora1.calcular(icms)); 
	    System.out.println("IPI: " + calculadora1.calcular(ipi)); 

	}

}
