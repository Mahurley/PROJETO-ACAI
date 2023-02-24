package telas.abrirpedido;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import listas.listaCLIENTE;
import listas.listaITEM;
import telas.clientes.cliente;
import telas.item.item;

public class ABRIRPEDIDO_settings extends listaCLIENTE {

	private static String NUMEROPEDIDO;
	private static cliente CLIENTEachado;
	private static JLabel lblTOTAL = new JLabel();
	private static int conta = 0;
	private static double totalCARRINHO ;
	private static JTable table;
	private static JTable tablecarrinho;
	
	
//	******************************************************************************************************************************************************************************************************************************************

	private static DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
			new String[] { "NOME", "PRECO" }) {

		private static final long serialVersionUID = 1337820077236880177L;
		boolean[] columnEditables = new boolean[] { false, false, false };

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};
	private static DefaultTableModel modelocarrinho = new DefaultTableModel(new Object[][] {},
			new String[] { "NOME", "PRECO", "QUANTIDADE", "ID" }) {
		private static final long serialVersionUID = -3037342760468190611L;
		boolean[] columnEditables = new boolean[] { false, false, false };

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};
//	******************************************************************************************************************************************************************************************************************************************

	public static void remove() {
		if ((Integer) modelocarrinho.getValueAt(tablecarrinho.getSelectedRow(), 2) == 1) {
			modelocarrinho.removeRow(tablecarrinho.getSelectedRow());
			atualizaVALORtotalnaTELA();
		} else {
			modelocarrinho.setValueAt(	(Integer) modelocarrinho.getValueAt(tablecarrinho.getSelectedRow(), 2) - 1,tablecarrinho.getSelectedRow(), 2);
		}
		atualizaVALORtotalnaTELA();
	}
//	******************************************************************************************************************************************************************************************************************************************

	public static item buscaITEMselecionadoJTABLE() {
		List<item> nova = new ArrayList<item>(listaITEM.getListaprincipalitem());
		nova.sort(Comparator.comparing(item::getNome));
		return nova.get(ABRIRPEDIDO_settings.getTable().getSelectedRow());

	}
//	******************************************************************************************************************************************************************************************************************************************

	public static void addCARRINHO(item recebe) {
		Object[] gravador = ABRIRPEDIDO.GETcriaOBJETO(recebe);
		procuraSEexisteCASOSIMeleADICIONA(gravador);
		procuraSEexisteALGUMcadastro(gravador);
		procuraPARAgravarNOcarrinho(gravador);
		conta = 0;
		atualizaVALORtotalnaTELA();

	}
//	******************************************************************************************************************************************************************************************************************************************

//	public Map<Integer,item> criaMAPparaFINALIZARcompra() {
//		Map<Integer,item> map = new HashMap<>();
//		for (int row = 0; row < modelocarrinho.getRowCount(); row++) {
//			String nome =(String) modelocarrinho.getValueAt(row, 0);
//			Double valor = (Double) modelocarrinho.getValueAt(row, 1);
//			int quantidade = (Integer) modelocarrinho.getValueAt(row, 2);
//			int id = (Integer) modelocarrinho.getValueAt(row, 3);
//			map.put(id, new item(id, nome, valor,quantidade));
//		}
//		
//		return map;
//	}
//	******************************************************************************************************************************************************************************************************************************************

	public static void atualizaVALORtotalnaTELA() {
		Double total = 0.0;
		for (int row = 0; row < modelocarrinho.getRowCount(); row++) {
			Double valor = (Double) modelocarrinho.getValueAt(row, 1) * (Integer) modelocarrinho.getValueAt(row, 2);
			total += valor;
			lblTOTAL.setText(String.format("TOTAL: R$ %.2f", total));
			
		}
		if (modelocarrinho.getRowCount() == 0) {
			lblTOTAL.setText(String.format("TOTAL: R$ %.2f", total));
		}
		 totalCARRINHO = total;

	}
//	******************************************************************************************************************************************************************************************************************************************

	public static void procuraSEexisteCASOSIMeleADICIONA(Object[] gravador) {
		for (int row = 0; row < modelocarrinho.getRowCount(); row++) {
			if (modelocarrinho.getValueAt(row, 0).equals(gravador[0])) {
				int val = (Integer) modelocarrinho.getValueAt(row, 2);
				modelocarrinho.setValueAt(val + 1, row, 2);
				break;
			}

		}

	}
//	******************************************************************************************************************************************************************************************************************************************

	public static void procuraSEexisteALGUMcadastro(Object[] gravador) {
		if (modelocarrinho.getRowCount() == 0) {
			modelocarrinho.addRow(gravador);
		}

	}
//	******************************************************************************************************************************************************************************************************************************************

	public static void procuraPARAgravarNOcarrinho(Object[] gravador) {

		for (int row = 0; row < modelocarrinho.getRowCount(); row++) {
			if (modelocarrinho.getValueAt(row, 0).equals(gravador[0])) {
				conta++;
				System.out.println("conta: " + conta);
			}

		}
		if (conta == 0) { // SE NAO HOUVER LINHA, ELE GRAVA
			modelocarrinho.addRow(gravador);

		}

	}
//	******************************************************************************************************************************************************************************************************************************************

//	public static void CRIANDOPEDIDOformadePAGAMENTO(PAGAMENTOS pagamento, pedido novo) {
//		listas.getListaprincipalcliente().remove(novo.getCliente());
//		int totalpedido = novo.getCliente().getQuantidadePEDIDOS()+1;
//		novo.getCliente().setQuantidadePEDIDOS(totalpedido);
//		listas.getListaprincipalcliente().add(novo.getCliente());
//		System.out.println("pedido criado com sucesso");
//		
//		try {
//			new TERCEIRO_aposconferirliberadoCADASTRO(new tiposCLIENTE(), novo.getCliente());
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		ABRIRPEDIDO_settings.getModelocarrinho().setRowCount(0);
//		ABRIRPEDIDO_settings.getModelo().setRowCount(0);
//		ABRIRPEDIDO_settings.getTablecarrinho().removeAll();
//		ABRIRPEDIDO_settings.getTable().removeAll();
//		ABRIRPEDIDO_settings.setNUMEROPEDIDO("");
//
//	}
	
//	******************************************************************************************************************************************************************************************************************************************

	public static JTable getTablecarrinho() {
		return tablecarrinho;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		ABRIRPEDIDO_settings.table = table;
	}

	public static void setTablecarrinho(JTable tablecarrinho) {
		ABRIRPEDIDO_settings.tablecarrinho = tablecarrinho;
	}

	public static int getConta() {
		return conta;
	}

	public static void setConta(int conta) {
		ABRIRPEDIDO_settings.conta = conta;
	}


	public static double getTotalCARRINHO() {
		return totalCARRINHO;
	}

	public static void setTotalCARRINHO(double totalCARRINHO) {
		ABRIRPEDIDO_settings.totalCARRINHO = totalCARRINHO;
	}

	public static JLabel getlblTOTAL() {
		return lblTOTAL;
	}

	public static void setlblTOTAL(JLabel lblTOTAL) {
		ABRIRPEDIDO_settings.lblTOTAL = lblTOTAL;
	}

	public static DefaultTableModel getModelo() {
		return modelo;
	}
	
	public static DefaultTableModel getModelocarrinho() {
		return modelocarrinho;
	}

	public static void setModelo(DefaultTableModel modelo) {
		ABRIRPEDIDO_settings.modelo = modelo;
	}

	public static void setModelocarrinho(DefaultTableModel modelocarrinho) {
		ABRIRPEDIDO_settings.modelocarrinho = modelocarrinho;
	}

	public static cliente getCLIENTEachado() {
		return CLIENTEachado;
	}

	public static void setCLIENTEachado(cliente cLIENTEachado) {
		CLIENTEachado = cLIENTEachado;
	}

	public static String getNUMEROPEDIDO() {
		return NUMEROPEDIDO;
	}

	public static void setNUMEROPEDIDO(String nUMEROPEDIDO) {
		NUMEROPEDIDO = nUMEROPEDIDO;
	}

	
	
}
