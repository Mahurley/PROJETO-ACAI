package telas.abrirpedido.settings;

import listas.listaCLIENTE;
import listas.listaPEDIDO;
import telas.abrirpedido.ABRIRPEDIDO_settings;
import telas.clientes.cliente;

public class procurarCELULARlista extends listaCLIENTE{

	public boolean procurar(String nome) {

		for (cliente cliente : getListaprincipalcliente()) {
			if (cliente.getTelefone().compareTo(nome) == 0) {
				ABRIRPEDIDO_settings.setCLIENTEachado(cliente);
				System.out.println("Achei o Cliente: " + cliente.getNome());
				return true;
			}
		}

		return false;
	}
	public boolean procurarLEITURA(String nome) {

		for (cliente cliente : getListaprincipalcliente()) {
			if (cliente.getTelefone().compareTo(nome) == 0) {
				listaPEDIDO.setCLIENTEachadoLEITURA(cliente);
				return true;
			}
		}

		return false;
	}
}
