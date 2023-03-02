package telas.abrirpedido.settings;

import controleSQL.funcoes.BuscaTodosDaTabela;
import telas.abrirpedido.ABRIRPEDIDO_settings;
import telas.clientes.cliente;

public class procurarCELULARlista{

	public boolean procurar(String nome) {
		
		for (cliente cliente : new BuscaTodosDaTabela().getCliente()) {
			if (cliente.getTelefone().compareTo(nome) == 0) {
				ABRIRPEDIDO_settings.setCLIENTEachado(cliente);
				System.out.println("Achei o Cliente: " + cliente.getNome());
				return true;
			}
		}

		return false;
	}

}
