package Banco.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import Banco.dal.CadastroDAO;
import Banco.dal.SaldoDAO;
import Banco.model.Cadastro;
import Banco.model.Saldo;

@ManagedBean(name = "mSaldoBean")
public class MSaldoBean {
	private Saldo saldo = new Saldo();
	private List<Saldo> saldos = new ArrayList<Saldo>();
	private int idCad;
	
	public int getIdCad() {
		return idCad;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	public Saldo getSaldo() {
		return saldo;
	}
	public List<Saldo> getSaldos() {
		return saldos;
	}
	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}
	public void setSaldos(List<Saldo> saldos) {
		this.saldos = saldos;
	}
	public String gravarSaldo(Saldo s){
		Cadastro c = CadastroDAO.buscarCadastroPorId(idCad);
		s.setCadastro(c);
		SaldoDAO.adicionarSaldo(s);
		return "AreaCliente.xhtml?faces-redirect=true";
	}
}
