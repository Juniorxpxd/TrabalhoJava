package Banco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cadastro")
public class Cadastro{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCad", nullable=false, unique=true)
	private int idCad;
	private String nome;
	@Column(name="email", nullable=false, unique=true)
	private String email;
	@Column(name="senha", nullable=false, unique=false)
	private String senha;
	private String telefone;
	private String datanasc;
	private String sexo;
	private float saldo = 50;
	private float poupanca = 20;
	private String rg;
	private int conta = 1;
	@ManyToOne
	private Agencia agencia;
	
	
	public float getPoupanca() {
		return poupanca;
	}
	public void setPoupanca(float poupanca) {
		this.poupanca = poupanca;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public int getIdCad() {
		return idCad;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
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
	public String getDataNasc() {
		return datanasc;
	}
	public String getSexo() {
		return sexo;
	}
	public String getRg() {
		return rg;
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
	public void setDataNasc(String datanasc) {
		this.datanasc = datanasc;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
