package telas.buscapedidos;


import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import telas.clientes.cliente;
import telas.item.item;

public class BUSCAPEDIDO_settings {

	private static String NUMEROPEDIDO;
	private static cliente CLIENTEachado;
	private static JLabel lblTOTAL = new JLabel();
	private static int conta = 0;
	private static double totalCARRINHO ;
	private static JTable tableBUSCApedido;
	
//	******************************************************************************************************************************************************************************************************************************************

	private static DefaultTableModel modelobuscapedido = new DefaultTableModel(new Object[][] {},
			new String[] { "NOME", "PRECO", "QUANTIDADE", "ID" }) {
				private static final long serialVersionUID = -6664891039793316203L;
		boolean[] columnEditables = new boolean[] { false, false, false };

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};

	private static Object[] criaOBJETOitem(item recebe) {
		Object[] gravador = new Object[4];
		gravador[0] = recebe.getNome();
		gravador[1] = recebe.getValor();
		gravador[2] = recebe.getQuantidade();
		gravador[3] = recebe.getId();
		return gravador;

	}
//	******************************************************************************************************************************************************************************************************************************************

	public static JTable getTableBUSCApedido() {
		return tableBUSCApedido;
	}


	public static void setTableBUSCApedido(JTable tableBUSCApedido) {
		BUSCAPEDIDO_settings.tableBUSCApedido = tableBUSCApedido;
	}

	public static int getConta() {
		return conta;
	}

	public static void setConta(int conta) {
		BUSCAPEDIDO_settings.conta = conta;
	}


	public static double getTotalCARRINHO() {
		return totalCARRINHO;
	}

	public static void setTotalBUSCApedido(double totalBUSCApedido) {
		BUSCAPEDIDO_settings.totalCARRINHO = totalBUSCApedido;
	}

	public static JLabel getlblTOTAL() {
		return lblTOTAL;
	}

	public static void setlblTOTAL(JLabel lblTOTAL) {
		BUSCAPEDIDO_settings.lblTOTAL = lblTOTAL;
	}

	
	public static DefaultTableModel getModeloBUSCApedido() {
		return modelobuscapedido;
	}

	public static void setModelocarrinho(DefaultTableModel modelocarrinho) {
		BUSCAPEDIDO_settings.modelobuscapedido = modelocarrinho;
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
