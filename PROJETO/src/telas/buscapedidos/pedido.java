package telas.buscapedidos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import controleSQL.CriacaoCliente;
import controleSQL.CriacaoPedido;
import recursos.transformaSTRINGemDATE;
import telas.abrirpedido.formasdepagamento.PAGAMENTOS;
import telas.clientes.cliente;
import telas.item.item;

public class pedido {
	
	private String ID;
	private cliente cliente;
	private PAGAMENTOS formaDEpagamento;
	private double valorTOTAL;
	private Map<Integer, item> tabela;
	private String data;
	
	public pedido(String iD,cliente cliente,double valorTOTAL ,Map<Integer, item> tabela) {
		this.ID = iD;
		this.cliente = cliente;
		this.valorTOTAL = valorTOTAL;
		this.tabela = tabela;
		this.data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
	
	public pedido(String iD,cliente cliente, PAGAMENTOS formaDEpagamento,double valorTOTAL,String data ,Map<Integer, item> tabela) {
		this.ID = iD;
		this.cliente = cliente;
		this.formaDEpagamento = formaDEpagamento;
		this.valorTOTAL = valorTOTAL;
		this.tabela = tabela;
		this.data = data;

	}
	
	public pedido() {
		// TODO Auto-generated constructor stub
	}

	public void criar(pedido criado) {
		//adiciona(criado);
		new CriacaoPedido().getCriar(criado);
	}

	public LocalDate BUSCAporDATA() {
		return new transformaSTRINGemDATE().transformarDATAcomHORARIO(data);

	}
	
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	

}
