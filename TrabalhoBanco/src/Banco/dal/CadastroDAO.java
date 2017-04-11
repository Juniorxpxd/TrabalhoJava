package Banco.dal;

import java.util.ArrayList;
import Banco.model.Cadastro;

public class CadastroDAO {
	private static ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
	
	public static void addCadastro(Cadastro c){
		c.setId(cadastros.size() + 1);
		cadastros.add(c);
	}
	public static void removerCadastro(Cadastro c){
		cadastros.remove(c);
	}
	public static ArrayList<Cadastro> retornarLista(){
		return cadastros;
	}
	public static Cadastro buscarCadastroPorID(int id){
		for(Cadastro Cadastro: cadastros){
			if(Cadastro.getId() == id){
				return Cadastro;
			}
		}
		return null;
	}
}
