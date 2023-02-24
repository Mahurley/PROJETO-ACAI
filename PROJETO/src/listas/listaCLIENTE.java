package listas;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultListModel;
import telas.clientes.cliente;
import telas.item.item;

public class listaCLIENTE extends tipoLISTA {

	private static Set<cliente> listaprincipalcliente = new HashSet<>();
	private static Map<Integer, cliente> mapprincipalcliente = new HashMap<>();
	private static DefaultListModel<cliente> listmodelcliente = new DefaultListModel<cliente>();
	
	

	public void adiciona(Object retorno) {
		cliente novocliente = (cliente) retorno;
		listaprincipalcliente.add(novocliente);
		mapprincipalcliente.put(novocliente.getId(), novocliente);
		listmodelcliente.addElement(novocliente);

	}


	public boolean procurarNOMElista(Object nome) {

		cliente novocliente = (cliente) nome;
		for (cliente item : listaprincipalcliente) {
			if (item.getNome().compareTo(novocliente.getNome()) == 0) {
				return true;
			}
		}

		return false;
	}

	
	public static Set<cliente> getListaprincipalcliente() {
		return listaprincipalcliente;
	}

	public static void setListaprincipalcliente(Set<cliente> listaprincipalcliente) {
		listaCLIENTE.listaprincipalcliente = listaprincipalcliente;
	}

	public static Map<Integer, cliente> getMapprincipalcliente() {
		return mapprincipalcliente;
	}

	public static void setMapprincipalcliente(Map<Integer, cliente> mapprincipalcliente) {
		listaCLIENTE.mapprincipalcliente = mapprincipalcliente;
	}

	public static DefaultListModel<cliente> getListmodelcliente() {
		return listmodelcliente;
	}

	public static void setListmodelcliente(DefaultListModel<cliente> listmodelcliente) {
		listaCLIENTE.listmodelcliente = listmodelcliente;
	}



}
