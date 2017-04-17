package Banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cadastro.Cartao")
public class Cartao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCar;
	private float renda;
	private String cartao;
	
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public float getRenda() {
		return renda;
	}
	public void setRenda(float renda) {
		this.renda = renda;
	}
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
}
