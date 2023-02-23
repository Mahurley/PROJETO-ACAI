package geradorcsv.validacao;


import geradorcsv.tipos.tiposARQUIVOS;

public class PRIMEIRO_leituradecadalinhaCSV {
	public static void leitura(tiposARQUIVOS qualtipoarquivo, Object recebe) {
		
		if (qualtipoarquivo.leitura()) {
			new SEGUNDO_verificaSEnomeEXISTE(qualtipoarquivo, recebe);
		}else {
			throw new RuntimeException("Validação 1 - FALHOU");
		}
		
		
//		try {
//			Scanner CSV = new Scanner(new File(qualtipoarquivo.caminhoCSV()));
//			while (CSV.hasNextLine()) {
//				String linha = CSV.nextLine();
//				Scanner scanlinha = new Scanner(linha);
//				scanlinha.useLocale(Locale.US);
//				scanlinha.useDelimiter(qualtipoarquivo.delimiterdalinha());
//				scanlinha.close();
//			}
//			CSV.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("Não encontramos o arquivo CSV");
//			e.printStackTrace();
//		}

	}
	
	
}
