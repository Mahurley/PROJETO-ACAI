package telas.pedido;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import controleSQL.criacao.CriacaoPedido;
import telas.clientes.cliente;
import telas.item.item;
import telas.pedido.FormaDePagamento.PAGAMENTOS;

public class pedido {
	
	private String ID;
	private cliente cliente;
	private PAGAMENTOS formaDEpagamento;
	private double valorTOTAL;
	private Map<Integer, item> tabela;
	private Timestamp data;
	
	public pedido(String iD,cliente cliente,double valorTOTAL ,Map<Integer, item> tabela) {
		this.ID = iD;
		this.cliente = cliente;
		this.valorTOTAL = valorTOTAL;
		this.tabela = tabela;
		this.data = Timestamp.valueOf(LocalDateTime.now());
		//this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
	
	public pedido(String iD,cliente cliente, PAGAMENTOS formaDEpagamento,double valorTOTAL,Timestamp data ,Map<Integer, item> tabela) {
		this.ID = iD;
		this.cliente = cliente;
		this.formaDEpagamento = formaDEpagamento;
		this.valorTOTAL = valorTOTAL;
		this.tabela = tabela;
		this.data = data;

	}
	
	public pedido() {
	}

	public void criar(pedido criado) {
		new CriacaoPedido().getCriar(criado);
	}

//	public LocalDate BUSCAporDATA() {
//		return new TransformaStringEmLocalDate().DATAcomHORARIO(data);
//
//	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public cliente getCliente() {
		return cliente;
	}
	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}
	public PAGAMENTOS getFormaDEpagamento() {
		return formaDEpagamento;
	}
	public void setFormaDEpagamento(PAGAMENTOS formaDEpagamento) {
		this.formaDEpagamento = formaDEpagamento;
	}
	public Map<Integer, item> getTabela() {
		return tabela;
	}
	public void setTabela(Map<Integer, item> tabela) {
		this.tabela = tabela;
	}


	public double getValorTOTAL() {
		return valorTOTAL;
	}


	public void setValorTOTAL(double valorTOTAL) {
		this.valorTOTAL = valorTOTAL;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	
	
	
	

}
