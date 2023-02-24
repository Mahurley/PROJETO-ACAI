package geradorcsv.validacao;


import geradorcsv.tipos.tiposARQUIVOS;

public class PRIMEIRO_leituradecadalinhaCSV {
	public static void leitura(tiposARQUIVOS qualtipoarquivo, Object recebe) {
		
		if (qualtipoarquivo.leitura()) {
			new SEGUNDO_verificaSEnomeEXISTE(qualtipoarquivo, recebe);
		}else {
			throw new RuntimeException("Validação 1 - FALHOU");
		}
		
	}
	
	
}
