package Banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pagamento")
public class Pagamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPag;
	private String codBarras;
	private String data;
	private double valor;
	@OneToOne
	private Cadastro cadastro;
	public int getIdPag() {
		return idPag;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public String getData() {
		return data;
	}
	public double getValor() {
		return valor;
	}
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setIdPag(int idPag) {
		this.idPag = idPag;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
}
