package JeanKoval.com.github.dominio;

public class Curso extends Conteudo {
	
	private Integer cargaHoraria;
	
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
		return "Curso{" +
				"titulo='" + getTitulo() + "' "+
				"descricao='" + getDescricao() + "' "+
				"Carga Horaria='" + cargaHoraria + "' "+
				"}";
	}
	
	@Override
	public double calcularXp() {
		return XP_PADRAO * cargaHoraria;
	}
}
