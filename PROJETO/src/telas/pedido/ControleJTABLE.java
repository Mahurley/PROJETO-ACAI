package telas.pedido;

import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.FormSpec.DefaultAlignment;

import telas.item.item;
import telas.pedido.AbrirPedido.ABRIRPEDIDO;

public class ControleJTABLE {
	
	public ControleJTABLE(DefaultTableModel modelo,item recebe, int conta) {
		addCARRINHO(modelo, recebe,conta);
	}
	
	public void addCARRINHO(DefaultTableModel modelo,item recebe, int conta) {
		Object[] gravador = ABRIRPEDIDO.GETcriaOBJETO(recebe);
		ProcuraSeExisteCasoSimEleAdiciona(modelo, gravador);
		ProcuraSeExisteAlgumCadastro(modelo, gravador);
		ProcuraParaGravarNoCarrinho(modelo, gravador,conta);


	}
	
//	******************************************************************************************************************************************************************************************************************************************

	public void ProcuraSeExisteCasoSimEleAdiciona(DefaultTableModel modelo,Object[] gravador) {
		for (int row = 0; row < modelo.getRowCount(); row++) {
			if (modelo.getValueAt(row, 0).equals(gravador[0])) {
				int val = (Integer) modelo.getValueAt(row, 2);
				modelo.setValueAt(val + 1, row, 2);
				break;
			}

		}

	}
//	******************************************************************************************************************************************************************************************************************************************

	public void ProcuraSeExisteAlgumCadastro(DefaultTableModel modelo,Object[] gravador) {
		if (modelo.getRowCount() == 0) {
			modelo.addRow(gravador);
		}

	}
//	******************************************************************************************************************************************************************************************************************************************

	public void ProcuraParaGravarNoCarrinho(DefaultTableModel modelo,Object[] gravador,int conta) {

		for (int row = 0; row < modelo.getRowCount(); row++) {
			if (modelo.getValueAt(row, 0).equals(gravador[0])) {
				conta++;
			}

		}
		if (conta == 0) { // SE NAO HOUVER LINHA, ELE GRAVA
			modelo.addRow(gravador);

		}

	}
}
