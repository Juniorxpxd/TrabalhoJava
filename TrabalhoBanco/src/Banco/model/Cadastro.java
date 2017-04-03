package Banco.model;

public class Cadastro {
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String data;
	private String sexo;
	private String rg;
	private Endereco endereço;
	private Agencia agencia;
	private Pessoa pessoa;
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getData() {
		return data;
	}
	public String getSexo() {
		return sexo;
	}
	public String getRg() {
		return rg;
	}
	public Endereco getEndereço() {
		return endereço;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public void setEndereço(Endereco endereço) {
		this.endereço = endereço;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
