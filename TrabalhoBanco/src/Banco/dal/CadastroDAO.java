package Banco.dal;

import java.util.ArrayList;
import Banco.model.Cadastro;
import Banco.model.Endereco;

public class CadastroDAO {
	private static ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
	
	public static void addCadastro(Cadastro c){
		cadastros.add(c);
	}
	public static void removerCadastro(Cadastro c){
		cadastros.remove(c);
	}
	public static ArrayList<Cadastro> retornarLista(){
		return cadastros;
	}
}
