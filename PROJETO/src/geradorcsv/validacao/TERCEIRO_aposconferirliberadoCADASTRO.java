package geradorcsv.validacao;

import java.io.IOException;

import geradorcsv.tipos.tiposARQUIVOS;

public class TERCEIRO_aposconferirliberadoCADASTRO {
	public TERCEIRO_aposconferirliberadoCADASTRO(tiposARQUIVOS tipoarquivo,Object recebe) {
		try {
			tipoarquivo.liberadoCADASTRO(recebe);
		} catch (IOException e) {
			throw new RuntimeException("Validação 3 - FALHOU");
		}
	}
	
	
}
