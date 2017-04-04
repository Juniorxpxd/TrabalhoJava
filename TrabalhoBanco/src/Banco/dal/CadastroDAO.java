package Banco.dal;

import java.util.ArrayList;
import Banco.model.Cadastro;

public class CadastroDAO {
	private static ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
	
	public static void addCadastro(Cadastro c){
		cadastros.add(c);
		System.out.println("N�mero de registros: " + cadastros.size());
	}
	public static ArrayList<Cadastro> retornarLista(){
		return cadastros;
	}
}
