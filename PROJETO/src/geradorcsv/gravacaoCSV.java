package geradorcsv;

import geradorcsv.tipos.tiposARQUIVOS;
import geradorcsv.validacao.INICIO_validacao;

public class gravacaoCSV {

	public gravacaoCSV(tiposARQUIVOS tipoarquivo, Object recebe) {

		new INICIO_validacao(tipoarquivo, recebe);
	}

}
