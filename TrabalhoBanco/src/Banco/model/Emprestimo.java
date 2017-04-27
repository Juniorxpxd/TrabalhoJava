package Banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmp;
	private double saldoE = 0;
	private String motivo;
	private String data;
	@OneToOne
	private Cadastro cadastro;
	
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	public int getIdEmp() {
		return idEmp;
	}
	public double getSaldoE() {
		return saldoE;
	}
	public String getMotivo() {
		return motivo;
	}
	public String getData() {
		return data;
	}
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}
	public void setSaldoE(double saldoE) {
		this.saldoE = saldoE;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public void setData(String data) {
		this.data = data;
	}
}
