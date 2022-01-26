package JeanKoval.com.github.dominio;

import java.time.LocalDate;

abstract public class Conteudo {
	
	protected static final Double XP_PADRAO = 10d;
	
	private String titulo;
	private String descricao;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public abstract double calcularXp();

}
