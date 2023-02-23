package telas.produtos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import recursos.listas.listaITEM;

public class item extends listaITEM implements Comparable<item> {

	private int id;
	private String nome;
	private double valor;
	private int quantidade;


	public item(String nome, double valor, int quantidade) {

		this.id = IDGERADORitem();
		this.valor = valor;
		this.quantidade = quantidade;
		this.nome = nome;
	}
	
	public item(int id,String nome, double valor, int quantidade) {

		this.id = id;
		this.valor = valor;
		this.quantidade = quantidade;
		this.nome = nome;
	}
	

	public item() {
		// TODO Auto-generated constructor stub
	}

	public void criar(item criado) {
		adiciona(criado);
		

	}
	@Override
	public int compareTo(item o) {
		return this.nome.compareTo(o.nome);
	}

	@Override
	public String toString() {
		return String.format("Nome: %-20s | Valor = R$%5.2f | Quantidade: %3d", nome, valor, quantidade);
	}

	public int getId() {
		return id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private static int IDGERADORitem() {
		List<item> listagerada = new ArrayList<>(getListaprincipalitem());
		listagerada.sort(Comparator.comparing(item::getId));
		int id = 0;
		for (int i = 0; i <= listagerada.size(); i++) {
			if (!getMapprincipalitem().containsKey(i)) {
				id = i;
				System.out.println("Achei este ID: " + id);
				break;
			} else {
				System.out.println("Ja existe este ID!");
			}
		}
		return id;

	}
	
}
