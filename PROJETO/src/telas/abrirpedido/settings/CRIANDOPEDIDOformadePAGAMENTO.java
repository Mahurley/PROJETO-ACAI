package telas.abrirpedido.settings;

import geradorcsv.tipos.tiposCLIENTE;
import geradorcsv.validacao.TERCEIRO_aposconferirliberadoCADASTRO;
import telas.abrirpedido.ABRIRPEDIDO_settings;
import telas.abrirpedido.formasdepagamento.PAGAMENTOS;
import telas.buscapedidos.pedido;

public class CRIANDOPEDIDOformadePAGAMENTO extends ABRIRPEDIDO_settings{

//	******************************************************************************************************************************************************************************************************************************************
	
	public CRIANDOPEDIDOformadePAGAMENTO(PAGAMENTOS pagamento, pedido novo) {
		
		
		
		novo.setFormaDEpagamento(pagamento);
		getListaprincipalcliente().remove(novo.getCliente());
		int totalpedido = novo.getCliente().getQuantidadePEDIDOS()+1;
		novo.getCliente().setQuantidadePEDIDOS(totalpedido);
		getListaprincipalcliente().add(novo.getCliente());
		System.out.println("pedido criado com sucesso");
		
		new TERCEIRO_aposconferirliberadoCADASTRO(new tiposCLIENTE(), novo.getCliente());
		
		getModelo().setRowCount(0);
		getModelocarrinho().setRowCount(0);
		getTablecarrinho().removeAll();
		getTable().removeAll();
		ABRIRPEDIDO_settings.setNUMEROPEDIDO("");

	}
	
//	******************************************************************************************************************************************************************************************************************************************

}
