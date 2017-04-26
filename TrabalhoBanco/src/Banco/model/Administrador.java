package Banco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Administrador")
public class Administrador {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="idAdm", nullable=false, unique=true)
		private int idAdm;
		private String nome;
		@Column(name="email", nullable=false, unique=true)
		private String email;
		@Column(name="senha", nullable=false, unique=false)
		private String senha;
		
		public int getIdAdm() {
			return idAdm;
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
		public void setIdAdm(int idAdm) {
			this.idAdm = idAdm;
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
}
