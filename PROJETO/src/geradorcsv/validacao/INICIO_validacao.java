package geradorcsv.validacao;

import geradorcsv.tipos.tiposARQUIVOS;

public class INICIO_validacao {

	public INICIO_validacao(tiposARQUIVOS tipoarquivo, Object recebe) {

		PRIMEIRO_leituradecadalinhaCSV.leitura(tipoarquivo, recebe);
	}

}
