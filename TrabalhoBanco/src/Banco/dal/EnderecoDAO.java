package Banco.dal;

import java.util.ArrayList;

import Banco.model.Endereco;

public class EnderecoDAO {
	private static ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	public static void adicionarEndereco(Endereco c){
		enderecos.add(c);
	}
	
	public static ArrayList<Endereco> retornarLista(){
		return enderecos;
	}
}
