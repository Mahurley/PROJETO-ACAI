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

import listas.listaCLIENTE;
import telas.clientes.cliente;

public class tiposCLIENTE extends listaCLIENTE implements tiposARQUIVOS{

	@Override
	public String caminhoCSV() {	
		return "arquivosCSV/cliente.csv";
	}

	@Override
	public boolean leitura() {
		try {
			Scanner CSV = new Scanner(new File(caminhoCSV()));
			getListmodelcliente().clear();
			getListaprincipalcliente().clear();
			getMapprincipalcliente().clear();
			while (CSV.hasNextLine()) {
				String linha = CSV.nextLine();
				Scanner scanlinha = new Scanner(linha);
				scanlinha.useLocale(Locale.US);
				scanlinha.useDelimiter("-");
				String nome = scanlinha.next();
				String datanascimento = scanlinha.next();
				String email = scanlinha.next();
				String telefone = scanlinha.next();
				int id = scanlinha.nextInt();
				int quantidadepedidos = scanlinha.nextInt();
				//System.out.println("Nome "+ nome + " | NASCIMENTO:" + datanascimento + " | EMAIL:" + email + " | TELEFONE:" + telefone + "PEDIDOS: " + quantidadepedidos);
				adiciona(new cliente(nome,datanascimento,email,telefone,id,quantidadepedidos));
				scanlinha.close();
			}
			CSV.close();
			System.out.println("Lista CLIENTE atualizada com Sucesso !!");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Não encontramos o arquivo de leitura CLIENTE...");
			return false;
			
		}
		
	}

	@Override
	public String delimiterdalinha() {
		return "-";
	}

	@Override
	public void liberadoCADASTRO(Object recebe) throws IOException {
		FileWriter gravandoNOVO = new FileWriter(caminhoCSV());
		cliente outro = new cliente(null, null, null, null);
		outro.criar((cliente) recebe);
		List<cliente> listcopia = new ArrayList<>(getListaprincipalcliente());
		listcopia.sort(Comparator.comparing(cliente::getId));
		FileWriter regravando = new FileWriter(new File(caminhoCSV()));
		for (int i = 0; i < listcopia.size(); i++) {
			gravandoNOVO.write(String.format(Locale.US, "%s-%s-%s-%s-%d-%d\n", listcopia.get(i).getNome(),
					listcopia.get(i).getDatanascimento(), listcopia.get(i).getEmail(),
					listcopia.get(i).getTelefone(), listcopia.get(i).getId(),listcopia.get(i).getQuantidadePEDIDOS()));
		}
		regravando.close();
		gravandoNOVO.close();
		
	}

	@Override
	public boolean procurarNOMElista(Object nome) {
		return super.procurarNOMElista(nome);
	}

}
