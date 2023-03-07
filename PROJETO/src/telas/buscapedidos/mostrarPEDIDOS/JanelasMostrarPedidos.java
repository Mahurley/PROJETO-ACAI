package telas.buscapedidos.mostrarPEDIDOS;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import controleSQL.CriacaoPedido;
import telas.buscapedidos.BUSCAPEDIDO;
import telas.buscapedidos.pedido;
import telas.item.item;

public class JanelasMostrarPedidos {

	public List<String> JanelaMES(String[] cALENDARIO, String descricao, int optionType) {
		JComboBox comboBox = new JComboBox(cALENDARIO);
		List<String> listaCOMpedidos = new ArrayList<String>();
		int MESescolhido = JOptionPane.showConfirmDialog(null, comboBox, descricao, optionType);
		if (MESescolhido == JOptionPane.YES_OPTION) {
			int mesparabuscar = comboBox.getSelectedIndex() + 1;
			//listaCOMpedidos = new CriacaoPedido().procurarPEDIDOporMES(mesparabuscar);
		} else {
			throw new InputMismatchException("Nenhum mes selecionado");
		}

		return listaCOMpedidos;
	}

	public void JanelaPEDIDOS(List<String> listaCOMpedidos) {
		JComboBox<Object> comboBoxPEDIDOS = new JComboBox<Object>(listaCOMpedidos.toArray(new String[0]));
		int IDescolhido = JOptionPane.showConfirmDialog(null, comboBoxPEDIDOS, "PEDIDOS NO MES SELECIONADO | ",
				JOptionPane.YES_NO_OPTION);
		if (IDescolhido == JOptionPane.YES_OPTION) {
			if (comboBoxPEDIDOS.getSelectedItem() != null) {
				String ID = comboBoxPEDIDOS.getSelectedItem().toString();
				if (ID != null) {
					BUSCAPEDIDO.main(ID);
				}

			}
		}

	}

	public List<String> JanelaTELEFONE(String descricao, int optionType) {
		String TELEFONEescolhido = JOptionPane.showInputDialog(null, descricao, optionType);
		List<String> listaCOMpedidos = new ArrayList<String>();

		if (TELEFONEescolhido == null || TELEFONEescolhido.isBlank()) {
			new InputMismatchException("CAMPO VAZIO TELEFONE");
		} else {
			List<String> pedido = new CriacaoPedido().procurarPEDIDOporTELEFONE(TELEFONEescolhido);
			
			listaCOMpedidos = pedido ;
			return listaCOMpedidos;
		}
		return null;
	}

	public boolean JanelaPEDIDOStelefone(List<String> listaCOMpedidos) {
		if (listaCOMpedidos == null) {
			new InputMismatchException("Lista chegando com valor nulo");
			return false;
		}
		JComboBox comboBoxPEDIDOS = new JComboBox(listaCOMpedidos.toArray(new String[0]));
		int IDescolhido = JOptionPane.showConfirmDialog(null, comboBoxPEDIDOS, "PEDIDOS DO TELEFONE SELECIONADO | ",
				JOptionPane.YES_NO_OPTION);
		if (IDescolhido == JOptionPane.YES_OPTION) {
			if (comboBoxPEDIDOS.getSelectedItem() != null) {
				
				String ID = comboBoxPEDIDOS.getSelectedItem().toString();
				
				if (ID != null) {
					BUSCAPEDIDO.main(ID);
					return true;
				}

			}
		}
		return false;
	}

}
