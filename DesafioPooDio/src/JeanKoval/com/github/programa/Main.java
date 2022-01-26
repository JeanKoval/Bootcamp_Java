package JeanKoval.com.github.programa;

import java.time.LocalDate;

import JeanKoval.com.github.dominio.Bootcamp;
import JeanKoval.com.github.dominio.Curso;
import JeanKoval.com.github.dominio.Dev;
import JeanKoval.com.github.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso curso = new Curso();
		curso.setTitulo("Teste");
		curso.setDescricao("Testando");
		curso.setCargaHoraria(50);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Teste");
		mentoria.setDescricao("Testando");
		mentoria.setData(LocalDate.now());
		
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java");
		bootcamp.setDescricao("Descrição Bootcamp Java Developer");
		bootcamp.getConteudos().add(mentoria);
		bootcamp.getConteudos().add(curso);
		
		Dev devJean = new Dev();
		devJean.setNome("Jean Carlos");
		devJean.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos Jean: " + devJean.getConteudosInscritos());
		devJean.progredir();
		System.out.println("-");
		devJean.progredir();
		System.out.println("-");
		System.out.println("Conteudos Inscritos Jean: " + devJean.getConteudosInscritos());
		System.out.println("Conteudos Concluidos Jean: " + devJean.getConteudosConcluidos());
		System.out.println("XP: " + devJean.calcularTotalXp());
		
		System.out.println("---------");
		
		
		Dev devJoao = new Dev();
		devJoao.setNome("Joao Carlos");
		devJoao.inscreverBootcamp(bootcamp);
		System.out.println("Conteudos Inscritos Joao: " + devJoao.getConteudosInscritos());
		devJoao.progredir();
		System.out.println("-");
		System.out.println("Conteudos Inscritos Joao: " + devJoao.getConteudosInscritos());
		System.out.println("Conteudos Concluidos Joao: " + devJean.getConteudosConcluidos());
		System.out.println("XP: " + devJoao.calcularTotalXp());
	}

}
