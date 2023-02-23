package recursos.listas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import telas.produtos.item;

public class listaITEM extends tipoLISTA {

	private static Set<item> listaprincipalitem = new HashSet<>();
	private static Map<Integer, item> mapprincipalitem = new HashMap<>();
	private static DefaultListModel<item> listmodelitem = new DefaultListModel<item>();
	private static JList<item> jlistitem = new JList<item>(listmodelitem);


	public void adiciona(Object retorno) {
		item novoitem = (item) retorno;
		listaprincipalitem.add(novoitem);
		mapprincipalitem.put(novoitem.getId(), novoitem);
		listmodelitem.addElement(novoitem);
	}

	public static boolean procurar(int id) {
		return mapprincipalitem.containsKey(id);

	}

	public static item devolve(int id) {
		return mapprincipalitem.get(id);

	}

	public boolean procurarNOMElista(Object nome) {

		item novoitem = (item) nome;
		for (item item : listaprincipalitem) {
			if (item.getNome().compareTo(novoitem.getNome()) == 0) {
				return true;
			}
		}

		return false;
	}

	public static JList<item> getJlistitem() {
		return jlistitem;
	}

	public static void setJlistitem(JList<item> jlistitem) {
		listaITEM.jlistitem = jlistitem;
	}

	public static DefaultListModel<item> getListmodelitem() {
		return listmodelitem;
	}


	public static Map<Integer, item> getMapprincipalitem() {
		return mapprincipalitem;
	}

	public static Set<item> getListaprincipalitem() {
		return listaprincipalitem;
	}

}
