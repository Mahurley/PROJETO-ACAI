package telas.pedido.AbrirPedido.settings;

import controleSQL.criacao.TABELA;
import controleSQL.funcoes.AlterarValorTabela;
import telas.pedido.pedido;
import telas.pedido.AbrirPedido.ABRIRPEDIDO_settings;
import telas.pedido.FormaDePagamento.PAGAMENTOS;

public class CRIANDOPEDIDOformadePAGAMENTO extends ABRIRPEDIDO_settings{

//	******************************************************************************************************************************************************************************************************************************************
	
	public CRIANDOPEDIDOformadePAGAMENTO(PAGAMENTOS pagamento, pedido novo) {
		novo.setFormaDEpagamento(pagamento);
		new AlterarValorTabela().executar(TABELA.CLIENTE, "QUANTIDADE_PEDIDOS", novo.getCliente().getQuantidadePEDIDOS()+1,"ID" , novo.getCliente().getId());
		getModelo().setRowCount(0);
		getModelocarrinho().setRowCount(0);
		getTablecarrinho().removeAll();
		getTable().removeAll();
		ABRIRPEDIDO_settings.setNUMEROPEDIDO("");

	}
	
//	******************************************************************************************************************************************************************************************************************************************

}
