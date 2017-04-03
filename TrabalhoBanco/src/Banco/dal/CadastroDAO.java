package Banco.dal;

import java.util.ArrayList;
import Banco.model.Cadastro;

public class CadastroDAO {
	private static ArrayList<Cadastro> cadastro = new ArrayList<Cadastro>();
	
	public static void addCadastro(Cadastro c){
		cadastro.add(c);
		System.out.println("Número de registros: " + cadastro.size());
	}
	public static ArrayList<Cadastro> retornarLista(){
		return cadastro;
	}
}
