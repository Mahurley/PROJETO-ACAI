package telas.pedido.AbrirPedido.settings;


import controleSQL.funcoes.BuscaTodosDaTabela;
import telas.clientes.cliente;
import telas.pedido.AbrirPedido.ABRIRPEDIDO_settings;

public class procurarCELULARlista{

	public boolean procurar(String nome) {
		
		if (nome == null || nome.isBlank() || nome.isEmpty()) {
			return false;
		}
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
