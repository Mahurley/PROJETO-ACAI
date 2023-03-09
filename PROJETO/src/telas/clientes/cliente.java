package telas.clientes;
import java.sql.Date;

import controleSQL.criacao.CriacaoCliente;

public class cliente implements Comparable<cliente>{
	
	private String nome;
	private Date datanascimento;
	private String email;
	private String telefone;
	private int id;
	private int quantidadePEDIDOS = 0;
	
	public cliente(String nome, Date date, String email, String telefone) {
		this.nome = nome;
		this.datanascimento = date;
		this.email = email;
		this.telefone = telefone;
	}
	
	public cliente(String nome, Date datanascimento, String email, String telefone,int id,int quantidadePEDIDOS) {
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
	}
	
	public cliente() {
	}

	public void criar(cliente criar) {
		new CriacaoCliente().getCriar(criar);
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
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date date) {
		this.datanascimento = date;
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
	

	public int getQuantidadePEDIDOS() {
		return quantidadePEDIDOS;
	}

	public void setQuantidadePEDIDOS(int quantidadePEDIDOS) {
		this.quantidadePEDIDOS = quantidadePEDIDOS;
	}

}
