package Banco.model;

public class Endereco {

	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado; 
	private String pais;
	private Cadastro cadastro;
	
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	public String getRua() {
		return rua;
	}
	public String getNumero() {
		return numero;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado() {
		return estado;
	}
	public String getPais() {
		return pais;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
	

}
