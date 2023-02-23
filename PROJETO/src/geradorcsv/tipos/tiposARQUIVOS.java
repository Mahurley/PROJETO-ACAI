package geradorcsv.tipos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public interface tiposARQUIVOS {
	
	public abstract String caminhoCSV();
	public abstract boolean leitura();
	public abstract String delimiterdalinha();
	public abstract void liberadoCADASTRO(Object recebe) throws IOException;
	public abstract boolean procurarNOMElista(Object nome);
	
	public static void verificarCSV(tiposARQUIVOS tipo) throws IOException {
		try {
			procuraCSV(tipo);
		} catch (FileNotFoundException e) {
			System.out.println("Não encontramos o arquivo ("+ tipo.caminhoCSV() + ")");
			System.out.println("Estamos criando o arquivo " + tipo.caminhoCSV());
			criarCSV(tipo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void verificarTODOScsv() throws IOException {
		verificarCSV(new tiposCLIENTE());
		verificarCSV(new tiposPEDIDO());
		verificarCSV(new tiposITEM());
	}
	
	public static void leituraTODOScsv() {
		new tiposCLIENTE().leitura();
		new tiposITEM().leitura();
		new tiposPEDIDO().leitura();
	}
	
	private static void procuraCSV(tiposARQUIVOS tipo) throws IOException {
		FileReader verifica = new FileReader(tipo.caminhoCSV());
		verifica.close();

	}
	
	private static void criarCSV(tiposARQUIVOS tipo) throws IOException {
		FileWriter criando = new FileWriter(tipo.caminhoCSV());
		System.out.println("Arquivo criado com sucesso !");
		criando.close();

	}
	



}
