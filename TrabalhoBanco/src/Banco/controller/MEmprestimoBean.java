package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Banco.dal.AgenciaDAO;
import Banco.dal.CadastroDAO;
import Banco.dal.EmprestimoDAO;
import Banco.model.Agencia;
import Banco.model.Cadastro;
import Banco.model.Emprestimo;

@SessionScoped
@ManagedBean(name = "mEmprestimoBean")
public class MEmprestimoBean {
	private Emprestimo emprestimo = new Emprestimo();
	private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	private int idCad;
	
	public int getIdCad() {
		return idCad;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public List<Emprestimo> getEmprestimos() {
		return EmprestimoDAO.retornarLista();
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	public String gravarEmprestimo(Emprestimo e){
		Cadastro c = CadastroDAO.buscarCadastroPorId(idCad);
		e.setCadastro(c);
		EmprestimoDAO.adicionarEmprestimo(e);
		emprestimo = new Emprestimo();
		return "ComprovanteEmp.xhtml?faces-redirect=true";
	}
}
