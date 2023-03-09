package telas.item;


import controleSQL.criacao.CriacaoItem;

public class item implements Comparable<item> {

	private int id;
	private String nome;
	private double valor;
	private int quantidade;


	public item(String nome, double valor, int quantidade) {

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
		//adiciona(criado);
		new CriacaoItem().getCriar(criado);

	}
	@Override
	public int compareTo(item o) {
		return this.nome.compareTo(o.nome);
	}

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

	
	
}
