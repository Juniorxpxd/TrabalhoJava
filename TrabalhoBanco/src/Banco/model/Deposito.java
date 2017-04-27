package Banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Deposito")
public class Deposito {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDeposito;
	private float quantidade;
	@OneToOne
	private Cadastro cadastro;
	@OneToOne
	private Cadastro cadastro2;
	@OneToOne
	private Agencia agencia;
	
	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Cadastro getCadastro2() {
		return cadastro2;
	}

	public void setCadastro2(Cadastro cadastro2) {
		this.cadastro2 = cadastro2;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public int getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(int idDeposito) {
		this.idDeposito = idDeposito;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
}
