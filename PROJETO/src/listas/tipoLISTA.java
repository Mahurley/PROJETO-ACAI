package listas;

import telas.item.item;

public abstract class tipoLISTA {

	protected abstract void adiciona(Object retorno);
	protected abstract boolean procurarNOMElista(Object nome);
	
	protected static boolean procurarITEMlista(int id) {
		return listaITEM.getMapprincipalitem().containsKey(id);

	}

	protected static item devolveITEM(int id) {
		return listaITEM.getMapprincipalitem().get(id);

	}
}
