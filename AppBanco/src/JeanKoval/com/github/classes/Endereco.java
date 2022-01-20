package JeanKoval.com.github.classes;

import java.io.FileNotFoundException;

import JeanKoval.com.github.arquivos.Enderecos;

public class Endereco {

	private Integer id;
	private String  rua;
	private Integer numero;
	private String  cidade;
	private String  estado;
		
	public Endereco(Integer id, String rua, Integer numero, String cidade, String estado) {
		setId(id);
		setRua(rua);
		setNumero(numero);
		setCidade(cidade);
		setEstado(estado);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
