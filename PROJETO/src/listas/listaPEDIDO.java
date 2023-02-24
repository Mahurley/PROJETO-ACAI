package listas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultListModel;
import telas.buscapedidos.pedido;
import telas.clientes.cliente;
import telas.item.item;

public class listaPEDIDO extends tipoLISTA {
	
	private static cliente CLIENTEachadoLEITURA;

	private static Set<pedido> listaprincipalpedido = new HashSet<>();
	private static Map<BigDecimal, pedido> mapprincipalpedido = new HashMap<>();
	private static DefaultListModel<pedido> listmodelpedido = new DefaultListModel<pedido>();

	private static Map<Integer, item> pedidofinal = new HashMap<>();

	public void adiciona(Object retorno) {

		pedido novopedido = (pedido) retorno;
		listaprincipalpedido.add(novopedido);
		BigDecimal id = new BigDecimal(novopedido.getID());
		mapprincipalpedido.put(id, novopedido);
		listmodelpedido.addElement(novopedido);

	}

	public static boolean procurar(int id) {
		return listaITEM.getMapprincipalitem().containsKey(id);

	}

	public static item devolve(int id) {
		return listaITEM.getMapprincipalitem().get(id);

	}
	
	public static List<BigDecimal> procurarPEDIDOporMES(int mesrecebe) {
		List<BigDecimal> valor = new ArrayList<>(); 
		for (pedido pedido : listaprincipalpedido) {
			if (pedido.BUSCAporDATA().getMonthValue() == mesrecebe) {
				valor.add(new BigDecimal(pedido.getID()));
			}
			
		}
		return valor;
	}
	public static List<BigDecimal> procurarPEDIDOporTELEFONE(String telefonerecebe) {
		List<BigDecimal> valor = new ArrayList<>(); 
		for (pedido estepedido : listaprincipalpedido) {
			String telefone = estepedido.getCliente().getTelefone();
			
			if (telefone.equals(telefonerecebe)) {
				valor.add(new BigDecimal(estepedido.getID()));
			}
			
		}
		return valor;
	}

	public boolean procurarNOMElista(Object nome) {
		return false;
	}


	public static Set<pedido> getListaprincipalpedido() {
		return listaprincipalpedido;
	}

	public static void setListaprincipalpedido(Set<pedido> listaprincipalpedido) {
		listaPEDIDO.listaprincipalpedido = listaprincipalpedido;
	}

	public static Map<BigDecimal, pedido> getMapprincipalpedido() {
		return mapprincipalpedido;
	}

	public static void setMapprincipalpedido(Map<BigDecimal, pedido> mapprincipalpedido) {
		listaPEDIDO.mapprincipalpedido = mapprincipalpedido;
	}

	public static DefaultListModel<pedido> getListmodelpedido() {
		return listmodelpedido;
	}

	public static void setListmodelpedido(DefaultListModel<pedido> listmodelpedido) {
		listaPEDIDO.listmodelpedido = listmodelpedido;
	}

	public static Map<Integer, item> getPedidofinal() {
		return pedidofinal;
	}

	public static void setPedidofinal(Map<Integer, item> pedidofinal) {
		listaPEDIDO.pedidofinal = pedidofinal;
	}

	public static cliente getCLIENTEachadoLEITURA() {
		return CLIENTEachadoLEITURA;
	}

	public static void setCLIENTEachadoLEITURA(cliente cLIENTEachadoLEITURA) {
		CLIENTEachadoLEITURA = cLIENTEachadoLEITURA;
	}

	
}
