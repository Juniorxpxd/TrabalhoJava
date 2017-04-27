package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Banco.dal.CadastroDAO;
import Banco.dal.PagamentoDAO;
import Banco.model.Cadastro;
import Banco.model.Pagamento;

@SessionScoped
@ManagedBean(name = "mPagamentoBean")
public class MPagamentoBean {
	private Pagamento pagamento = new Pagamento();
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
	private int idCad;
	
	public int getIdCad() {
		return idCad;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public List<Pagamento> getPagamentos() {
		return PagamentoDAO.retornarLista();
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	public String gravarPagamento(Pagamento p){
		Cadastro e = CadastroDAO.buscarCadastroPorId(idCad);
		p.setCadastro(e);
		PagamentoDAO.adicionarPagamento(p);
		pagamento = new Pagamento();
		return "ComprovantePag.xhtml?faces-redirect=true";
	}
}
