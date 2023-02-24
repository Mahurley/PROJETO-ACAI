package telas.clientes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import listas.listaCLIENTE;

public class cliente extends listaCLIENTE implements Comparable<cliente>{
	
	private String nome;
	private String datanascimento;
	private String email;
	private String telefone;
	private int id;
	private int quantidadePEDIDOS = 0;
	
	public cliente(String nome, String datanascimento, String email, String telefone) {
		this.nome = nome;
		this.datanascimento = datanascimento;
		this.email = email;
		this.telefone = telefone;
		this.id = IDGERADORcliente();
	}
	
	public cliente(String nome, String datanascimento, String email, String telefone,int id,int quantidadePEDIDOS) {
		this.nome = nome;
		this.datanascimento = datanascimento;
		this.email = email;
		this.telefone = telefone;
		this.id = id;
		this.quantidadePEDIDOS = quantidadePEDIDOS;
	}
	
	public cliente(String nome, String telefone,int id) {
		this.nome = nome;
		this.telefone = telefone;
		this.id = IDGERADORcliente();
	}
	
	public void criar(cliente criar) {
		adiciona(criar);
	}
	
	@Override
	public int compareTo(cliente o) {
		return this.nome.compareTo(o.nome);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	private static int IDGERADORcliente() {
		List<cliente> listagerada = new ArrayList<>(getListaprincipalcliente());
		listagerada.sort(Comparator.comparing(cliente::getId));
		int id = 0;
		for (int i = 0; i <= listagerada.size(); i++) {
			if (!getMapprincipalcliente().containsKey(i)) {
				id = i;
				System.out.println("Achei este ID: " + id);
				break;
			} else {
				System.out.println("Ja existe este ID!");
			}
		}
		return id;

	}

	public int getQuantidadePEDIDOS() {
		return quantidadePEDIDOS;
	}

	public void setQuantidadePEDIDOS(int quantidadePEDIDOS) {
		this.quantidadePEDIDOS = quantidadePEDIDOS;
	}

}
