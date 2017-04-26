package Banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Poupanca")
public class Poupanca {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idPoup;
		private float poupanca;
		@OneToOne
		private Cadastro cadastro;
		
		public int getIdPoup() {
			return idPoup;
		}
		public float getPoupanca() {
			return poupanca;
		}
		public Cadastro getCadastro() {
			return cadastro;
		}
		public void setIdPoup(int idPoup) {
			this.idPoup = idPoup;
		}
		public void setPoupanca(float poupanca) {
			this.poupanca = poupanca;
		}
		public void setCadastro(Cadastro cadastro) {
			this.cadastro = cadastro;
		}
}
