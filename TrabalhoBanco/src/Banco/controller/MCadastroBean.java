package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Banco.dal.AgenciaDAO;
import Banco.dal.CadastroDAO;
import Banco.dal.CartaoDAO;
import Banco.dal.DepositoDAO;
import Banco.dal.EmprestimoDAO;
import Banco.dal.PagamentoDAO;
import Banco.dal.TransferenciaDAO;
import Banco.model.Agencia;
import Banco.model.Cadastro;
import Banco.model.Cartao;
import Banco.model.Deposito;
import Banco.model.Emprestimo;
import Banco.model.Pagamento;
import Banco.model.Transferencia;

@SessionScoped
@ManagedBean(name = "mCadastroBean")
public class MCadastroBean {
	private Cadastro cadastro = new Cadastro();
	private List<Cadastro> cadastros = new ArrayList<Cadastro>();
	private CadastroDAO cadastroDAO = new CadastroDAO();
	private int idAgen;
	private int idCar;

	
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public int getIdAgen() {
		return idAgen;
	}
	public void setIdAgen(int idAgen) {
		this.idAgen = idAgen;
	}
	public Cadastro getCadastro() {
		return cadastro;
	}
	public List<Cadastro> getCadastros() {
		return CadastroDAO.retornarLista();
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	public void setCadastros(List<Cadastro> cadastros) {
	}
	
	public String enviarDadosParaAlterar(Cadastro c) {
		this.cadastro = c;
		return "AlterarCliente.xhtml?faces-redirect=true";
	}
	public String enviarDadosParaAlterar2(Cadastro c) {
		this.cadastro = c;
		return "AlterarSaldo.xhtml?faces-redirect=true";
	}
	public String enviarDadosParaAlterar3(Cadastro c) {
		this.cadastro = c;
		return "AlterarConta.xhtml?faces-redirect=true";
	}
	public String enviarDadosParaAlterar5(Cadastro c) {
		this.cadastro = c;
		return "CriarCartao.xhtml?faces-redirect=true";
	}
	public String alterarCadastro(Cadastro c) {
		Agencia a = AgenciaDAO.buscarAgenciaPorId(idAgen);
		c.setAgencia(a);
		CadastroDAO.alterarCadastro(c);
		cadastro = new Cadastro();
		return "ListarCliente.xhtml?faces-redirect=true";
	}
	public String alterarSaldo(Cadastro c) {
		CadastroDAO.alterarCadastro(c);
		cadastro = new Cadastro();
		return "ListarSaldo.xhtml?faces-redirect=true";
	}
	public String alterarConta(Cadastro c) {
		CadastroDAO.alterarCadastro(c);
		cadastro = new Cadastro();
		return "InserirConta.xhtml?faces-redirect=true";
	}
	public String alterarCartao(Cadastro c) {
		CadastroDAO.alterarCadastro(c);
		cadastro = new Cadastro();
		return "InserirCartao.xhtml?faces-redirect=true";
	}
	public String removerCadastro(Cadastro c) {
		CadastroDAO.removerCadastro(c);
		cadastro = new Cadastro();
		return "ListarCliente.xhtml?faces-redirect=true";
	}
	public String removerCadastro2(Cadastro c) {
		CadastroDAO.removerCadastro(c);
		cadastro = new Cadastro();
		return "ListarSaldo.xhtml?faces-redirect=true";
	}
	public String gravarCadastro(Cadastro c){
		Agencia a = AgenciaDAO.buscarAgenciaPorId(idAgen);
		c.setAgencia(a);
		CadastroDAO.adicionarCadastro(c);
		cadastro = new Cadastro();
		return "Endereco.xhtml?faces-redirect=true";
	}
	public String buscarCadastro(){
		 cadastro = CadastroDAO.buscarCadastroPorNome(cadastro.getNome());
			if(cadastro == null){
				cadastro = new Cadastro();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome não encontrado!","Erro na Busca!"));
			       return null;
			   } else {
				   return "ClienteEncontrado.xhtml?faces-redirect=true";
			   }
		}
	public String enviar(){
		cadastro = CadastroDAO.getCadastro(cadastro.getEmail(), cadastro.getSenha());
		if(cadastro == null){
			cadastro = new Cadastro();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!","Erro no Login!"));
		       return null;
		   } else {
			   return "AreaCliente.xhtml?faces-redirect=true";
		   }
	}
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "Login.xhtml?faces-redirect=true";
	}
	public String alterarSaldo2(Cadastro c) {
		CadastroDAO.alterarCadastro(c);
		cadastro = new Cadastro();
		return "Deposito.xhtml?faces-redirect=true";
	}
	public String enviarDadosParaAlterar4(Cadastro c) {
		this.cadastro = c;
		return "AlterarPoupanca.xhtml?faces-redirect=true";
	}
	public String alterarPoupanca(Cadastro c) {
		CadastroDAO.alterarCadastro(c);
		cadastro = new Cadastro();
		return "Poupanca.xhtml?faces-redirect=true";
	}
}
