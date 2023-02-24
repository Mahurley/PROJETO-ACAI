package geradorcsv.tipos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import listas.listaITEM;
import telas.item.item;

public class tiposITEM extends listaITEM implements tiposARQUIVOS{

	@Override
	public String caminhoCSV() {
		return "arquivosCSV/item.csv";
	}

	@Override
	public boolean leitura() {
		try {
			Scanner CSV = new Scanner(new File(caminhoCSV()));
			getListmodelitem().clear();
			getListaprincipalitem().clear();
			getMapprincipalitem().clear();
			while (CSV.hasNextLine()) {
				String linha = CSV.nextLine();
				Scanner scanlinha = new Scanner(linha);
				scanlinha.useLocale(Locale.US);
				scanlinha.useDelimiter(",");
				int id = scanlinha.nextInt();
				String nome = scanlinha.next();
				double preco = scanlinha.nextDouble();
				int quantidade = scanlinha.nextInt();
				//System.out.println("ID "+ id + " | NOME:" + nome + " | PRECO:" + preco + " | QUANTIDADE:" + quantidade);
				adiciona(new item(id,nome,preco,quantidade));
				scanlinha.close();
			}
			CSV.close();
			System.out.println("Lista ITEM atualizada com Sucesso !!");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Não encontramos o arquivo de leitura ITEM...");
			return false;
		}
		
	}

	@Override
	public String delimiterdalinha() {
		return ",";
		
	}

	@Override
	public void liberadoCADASTRO(Object recebe) throws IOException {
		FileWriter gravandoNOVO = new FileWriter(caminhoCSV(), true);
		item outro = new item(null, 0, 0);
		outro.criar((item) recebe);
		List<item> listcopia = new ArrayList<>(getListaprincipalitem());
		listcopia.sort(Comparator.comparing(item::getId));
		FileWriter regravando = new FileWriter(new File(caminhoCSV()));
		for (int i = 0; i < listcopia.size(); i++) {
			gravandoNOVO.write(String.format(Locale.US, "%d,%s,%.2f,%d\n", listcopia.get(i).getId(),
					listcopia.get(i).getNome(), listcopia.get(i).getValor(), listcopia.get(i).getQuantidade()));
		}
		regravando.close();
		gravandoNOVO.close();
		
	}

	@Override
	public boolean procurarNOMElista(Object nome) {
		return super.procurarNOMElista(nome);
	}

}
