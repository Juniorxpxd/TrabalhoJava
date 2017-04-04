package Banco.controller;


import javax.faces.bean.ManagedBean;

import Banco.model.String;
 
@ManagedBean
public class PasswordView {

	private String senha;
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	 
}
