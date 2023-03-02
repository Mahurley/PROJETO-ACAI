package telas.abrirpedido.settings;

import controleSQL.funcoes.BuscaID;
import geradorcsv.tipos.tiposCLIENTE;
import geradorcsv.validacao.TERCEIRO_aposconferirliberadoCADASTRO;
import telas.abrirpedido.ABRIRPEDIDO_settings;
import telas.abrirpedido.formasdepagamento.TABELAS;
import telas.buscapedidos.pedido;
import telas.clientes.cliente;

public class CRIANDOPEDIDOformadePAGAMENTO extends ABRIRPEDIDO_settings{

//	******************************************************************************************************************************************************************************************************************************************
	
	public CRIANDOPEDIDOformadePAGAMENTO(TABELAS pagamento, pedido novo) {
		
		//seta o pagamento no pedido
		//atualizar cliente com ++ contador de pedido
		
		cliente cliente = new BuscaID().cliente(novo.getCliente().getId());
		cliente.setQuantidadePEDIDOS(cliente.getQuantidadePEDIDOS()+1);
		getModelo().setRowCount(0);
		getModelocarrinho().setRowCount(0);
		getTablecarrinho().removeAll();
		getTable().removeAll();
		ABRIRPEDIDO_settings.setNUMEROPEDIDO("");

	}
	
//	******************************************************************************************************************************************************************************************************************************************

}
