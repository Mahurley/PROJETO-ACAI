package geradorcsv.tipos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import recursos.listas.listaPEDIDO;
import telas.buscapedidos.pedido;
import telas.abrirpedido.formasdepagamento.PAGAMENTOS;
import telas.abrirpedido.settings.procurarCELULARlista;
import telas.clientes.cliente;
import telas.produtos.item;

public class tiposPEDIDO extends listaPEDIDO implements tiposARQUIVOS {

	@Override
	public String caminhoCSV() {
		return "pedido.csv";
	}

	@Override
	public boolean leitura() {
		try {
			Scanner CSV = new Scanner(new File(caminhoCSV()));
			getListmodelpedido().clear();
			getListaprincipalpedido().clear();
			getMapprincipalpedido().clear();
			Map<Integer,item> novomap = new HashMap<Integer,item>();
			while (CSV.hasNextLine()) {
				String linha = CSV.nextLine();
				Scanner scanlinha = new Scanner(linha);
				scanlinha.useLocale(Locale.US);
				scanlinha.useDelimiter("-");
				String ID = scanlinha.next();
				String telefonecliente = scanlinha.next();
				String formadepagamento = scanlinha.next();
				PAGAMENTOS pagamento = PAGAMENTOS.valueOf(formadepagamento);
				double valortotal = scanlinha.nextDouble();
				String data = scanlinha.next();
				while (scanlinha.hasNext()) {
					String idITEM = scanlinha.next();
					String quantidadeITEM = scanlinha.next();
					//System.out.println("Item na linha :" + idITEM + " com quantidade: " + quantidadeITEM);
					item chegando = devolve(Integer.parseInt(idITEM));
					chegando.setQuantidade(Integer.parseInt(quantidadeITEM));
					novomap.put(chegando.getId(), chegando);
				}
				
				new procurarCELULARlista().procurarLEITURA(telefonecliente);
				cliente novo = getCLIENTEachadoLEITURA();
				System.out.println("ID PEDIDO: " + ID + " | CLIENTE:" + novo.getTelefone() + " | FORMA DE PAGAMENTO:"
						+ formadepagamento + "VALOR TOTAL: " + valortotal + " | DATA: "+ data + " | ITENS:" + novomap);
				adiciona(new pedido(ID, novo, pagamento, valortotal,data ,novomap ));
				scanlinha.close();
			}
			CSV.close();
			System.out.println("Lista PEDIDO atualizada com Sucesso !!");
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Não encontramos o arquivo de leitura PEDIDO...");
			return false;
		}

	}

	@Override
	public String delimiterdalinha() {
		return "-";
	}

	@Override
	public void liberadoCADASTRO(Object recebe) throws IOException {
		FileWriter gravandoNOVO = new FileWriter(caminhoCSV(), true);
		pedido gravado =(pedido) recebe;
		gravado.criar(gravado);
		List<pedido> listcopia = new ArrayList<>(getListaprincipalpedido());
		listcopia.sort(Comparator.comparing(pedido::getID));
		FileWriter regravando = new FileWriter(new File(caminhoCSV()));
		for (int i = 0; i < listcopia.size(); i++) {
			String resposta = new String();
			List<item> novalistateste = new ArrayList<item>(gravado.getTabela().values());
			
			for (item cada : novalistateste) {
				resposta += String.valueOf(cada.getId()) + "-" + String.valueOf(cada.getQuantidade() + "-");
			}
			
			String id = listcopia.get(i).getID();
			String telefone = listcopia.get(i).getCliente().getTelefone();
			String pagamento = listcopia.get(i).getFormaDEpagamento().toString();
			double total = listcopia.get(i).getValorTOTAL();
			String data = listcopia.get(i).getData();
			
			
			
			gravandoNOVO.write(String.format(Locale.US, "%s-%s-%s-%f-%s-%s\n", id,telefone,pagamento, total, data ,resposta));
		}
		regravando.close();
		gravandoNOVO.close();

	}

	
	

}
