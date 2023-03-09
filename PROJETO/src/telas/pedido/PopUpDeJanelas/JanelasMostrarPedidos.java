package telas.pedido.PopUpDeJanelas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import controleSQL.criacao.CriacaoPedido;
import telas.pedido.BuscaPedido.BUSCAPEDIDO;

public class JanelasMostrarPedidos {

	public List<String> JanelaMES(String[] cALENDARIO, String descricao, int optionType) {
		JComboBox<String> comboBox = new JComboBox<String>(cALENDARIO);
		List<String> listaCOMpedidos = new ArrayList<String>();
		int MESescolhido = JOptionPane.showConfirmDialog(null, comboBox, descricao, optionType);
		if (MESescolhido == JOptionPane.YES_OPTION) {
			int mesparabuscar = comboBox.getSelectedIndex() + 1;
			listaCOMpedidos = new CriacaoPedido().procurarPEDIDOporMES(mesparabuscar);
			return listaCOMpedidos;
		} else {
			throw new InputMismatchException("Nenhum mes selecionado");
		}
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

			listaCOMpedidos = pedido;
			return listaCOMpedidos;
		}
		return null;
	}

	public boolean JanelaPEDIDOStelefone(List<String> listaCOMpedidos) {
		if (listaCOMpedidos == null) {
			new InputMismatchException("Lista chegando com valor nulo");
			return false;
		}
		JComboBox<String> comboBoxPEDIDOS = new JComboBox<String>(listaCOMpedidos.toArray(new String[0]));
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
