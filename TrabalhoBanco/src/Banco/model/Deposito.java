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
	private double quantidade;
	private double resultado;
	@OneToOne
	private Cadastro cadastro;

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
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

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double resultado) {
		this.quantidade = resultado;
	}
}
