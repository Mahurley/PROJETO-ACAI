package geradorcsv.validacao;

import geradorcsv.tipos.tiposARQUIVOS;
import telas.clientes.cadastrar;

public class SEGUNDO_verificaSEnomeEXISTE {
	public SEGUNDO_verificaSEnomeEXISTE(tiposARQUIVOS tipoarquivo,Object inteiro) {
			if (!tipoarquivo.procurarNOMElista(inteiro)) {
				new TERCEIRO_aposconferirliberadoCADASTRO(tipoarquivo, inteiro);
			} else {
				cadastrar.getLblRESPOSTA().setText("Já existe com este NOME criado");;

			}
		
		tipoarquivo.leitura();
	}
	
	
}
