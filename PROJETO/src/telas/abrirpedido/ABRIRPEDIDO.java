package telas.abrirpedido;

import recursos.horarioATUALIZADO;
import telas.abrirpedido.formasdepagamento.formaDEpagamento;
import telas.buscapedidos.pedido;
import telas.item.item;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SpringLayout;

import listas.listaITEM;

public class ABRIRPEDIDO extends ABRIRPEDIDO_settings {

	public static JFrame frmAberturaDeVenda;

	private static double totalPEDIDO;

//	******************************************************************************************************************************************************************************************************************************************

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					new ABRIRPEDIDO();
					ABRIRPEDIDO.frmAberturaDeVenda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	******************************************************************************************************************************************************************************************************************************************

	public ABRIRPEDIDO() {
		// tiposARQUIVOS.leituraTODOScsv();
		initialize();
	}

//	******************************************************************************************************************************************************************************************************************************************

	private void initialize() {

		frmAberturaDeVenda = new JFrame();
		frmAberturaDeVenda.setResizable(false);
		frmAberturaDeVenda.setTitle("ABERTURA DE VENDA");
		frmAberturaDeVenda.setBounds(100, 100, 808, 361);
		frmAberturaDeVenda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane();

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnADICIONA = new JButton("ADICIONA");
		btnADICIONA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(getTablecarrinho().getSelectedRow());
				addCARRINHO(buscaITEMselecionadoJTABLE());

			}
		});

//		******************************************************************************************************************************************************************************************************************************************

		JScrollPane scrollPane_1 = new JScrollPane();

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblLISTADEPRODUTOS = new JLabel("LISTA DE PRODUTROS");
		lblLISTADEPRODUTOS.setFont(new Font("Tahoma", Font.PLAIN, 33));

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblCARRINHO = new JLabel("CARRINHO");
		lblCARRINHO.setFont(new Font("Tahoma", Font.PLAIN, 33));

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("removendo item:" + getTable().getSelectedRow());

				remove();
			}
		});

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblNUMEROPEDIDO = new JLabel("Nº ID -");
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		String data = dateFormat.format(new Date());
		lblNUMEROPEDIDO.setText(data);
		ABRIRPEDIDO_settings.setNUMEROPEDIDO(lblNUMEROPEDIDO.getText());

//		******************************************************************************************************************************************************************************************************************************************

		setTablecarrinho(new JTable());
		scrollPane_1.setViewportView(getTablecarrinho());
		getTablecarrinho().setModel(getModelocarrinho());
		getTablecarrinho().getColumnModel().getColumn(0).setResizable(false);
		getTablecarrinho().getColumnModel().getColumn(1).setResizable(false);
		getTablecarrinho().addKeyListener(new KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE)
					remove();
			}
		});

//		******************************************************************************************************************************************************************************************************************************************

		setTable(new JTable());
		getTable().setModel(getModelo());
		getTable().getColumnModel().getColumn(0).setResizable(false);
		getTable().getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(getTable());
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, btnADICIONA, 6, SpringLayout.SOUTH, btnRemover);
		springLayout.putConstraint(SpringLayout.NORTH, lblCARRINHO, 0, SpringLayout.NORTH, lblLISTADEPRODUTOS);
		springLayout.putConstraint(SpringLayout.EAST, lblCARRINHO, -6, SpringLayout.WEST, lblNUMEROPEDIDO);
		springLayout.putConstraint(SpringLayout.NORTH, lblNUMEROPEDIDO, 22, SpringLayout.NORTH, lblLISTADEPRODUTOS);
		springLayout.putConstraint(SpringLayout.EAST, lblNUMEROPEDIDO, -10, SpringLayout.EAST,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 51, SpringLayout.NORTH,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 508, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, 237, SpringLayout.NORTH,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, 785, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnADICIONA, 384, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnADICIONA, 237, SpringLayout.NORTH,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnADICIONA, 504, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnRemover, 51, SpringLayout.NORTH,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnRemover, 384, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnRemover, 137, SpringLayout.NORTH,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnRemover, 504, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 51, SpringLayout.NORTH,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 7, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 237, SpringLayout.NORTH,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 380, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblLISTADEPRODUTOS, 7, SpringLayout.NORTH,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblLISTADEPRODUTOS, 28, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		frmAberturaDeVenda.getContentPane().setLayout(springLayout);
		frmAberturaDeVenda.getContentPane().add(lblLISTADEPRODUTOS);
		frmAberturaDeVenda.getContentPane().add(scrollPane);
		frmAberturaDeVenda.getContentPane().add(btnRemover);
		frmAberturaDeVenda.getContentPane().add(btnADICIONA);
		frmAberturaDeVenda.getContentPane().add(lblNUMEROPEDIDO);
		frmAberturaDeVenda.getContentPane().add(lblCARRINHO);
		frmAberturaDeVenda.getContentPane().add(scrollPane_1);

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblTOTAL = getlblTOTAL();
		springLayout.putConstraint(SpringLayout.NORTH, lblTOTAL, 6, SpringLayout.SOUTH, scrollPane_1);
		springLayout.putConstraint(SpringLayout.WEST, lblTOTAL, 0, SpringLayout.WEST, scrollPane_1);
		frmAberturaDeVenda.getContentPane().add(lblTOTAL);

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnFINALIZAR = new JButton("FINALIZAR");
		springLayout.putConstraint(SpringLayout.NORTH, btnFINALIZAR, 35, SpringLayout.SOUTH, scrollPane_1);
		springLayout.putConstraint(SpringLayout.WEST, btnFINALIZAR, 0, SpringLayout.WEST, scrollPane_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnFINALIZAR, -10, SpringLayout.SOUTH,
				frmAberturaDeVenda.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnFINALIZAR, 0, SpringLayout.EAST, scrollPane_1);
		btnFINALIZAR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFINALIZAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcao = JOptionPane.showConfirmDialog(null, "PODEMOS FINALIZAR A COMPRA ?",
						"NÃO SE ESQUECEU DE NENHUM ITEM??", JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					
					setTotalPEDIDO(getTotalCARRINHO());			

					Map<Integer, item> novomap = criaMAPparaFINALIZARcompra();

					formaDEpagamento.main(new pedido(lblNUMEROPEDIDO.getText(), ABRIRPEDIDO_settings.getCLIENTEachado(),
							getTotalCARRINHO(), novomap));
					setTotalPEDIDO(0.0);
				}
			}
		});
		frmAberturaDeVenda.getContentPane().add(btnFINALIZAR);

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblHORARIO = new JLabel("HORARIO");
		lblHORARIO.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblHORARIO, 0, SpringLayout.NORTH, btnFINALIZAR);
		springLayout.putConstraint(SpringLayout.WEST, lblHORARIO, 10, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		horarioATUALIZADO.buscar(lblHORARIO);
		frmAberturaDeVenda.getContentPane().add(lblHORARIO);

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblNOMECLIENTE = new JLabel("NOME:");
		String nomecliente = ABRIRPEDIDO_settings.getCLIENTEachado().getNome();
		lblNOMECLIENTE.setText("NOME: " + nomecliente);

		springLayout.putConstraint(SpringLayout.NORTH, lblNOMECLIENTE, 13, SpringLayout.SOUTH, scrollPane);
		springLayout.putConstraint(SpringLayout.WEST, lblNOMECLIENTE, 269, SpringLayout.WEST,
				frmAberturaDeVenda.getContentPane());
		frmAberturaDeVenda.getContentPane().add(lblNOMECLIENTE);

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblPEDIDOS = new JLabel("PEDIDOS: <dynamic>");
		int quantidadePEDIDOS = ABRIRPEDIDO_settings.getCLIENTEachado().getQuantidadePEDIDOS();
		lblPEDIDOS.setText("PEDIDOS: " + String.valueOf(quantidadePEDIDOS));

		springLayout.putConstraint(SpringLayout.NORTH, lblPEDIDOS, 0, SpringLayout.NORTH, btnFINALIZAR);
		springLayout.putConstraint(SpringLayout.WEST, lblPEDIDOS, 0, SpringLayout.WEST, lblNOMECLIENTE);
		frmAberturaDeVenda.getContentPane().add(lblPEDIDOS);

//		******************************************************************************************************************************************************************************************************************************************

		getTable().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					addCARRINHO(buscaITEMselecionadoJTABLE());
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		atualizarJTABLE();
	}

//	******************************************************************************************************************************************************************************************************************************************

	private void ADDitemJTABLE(item recebe) {
		getModelo().addRow(criaOBJETO(recebe));

	}

//	******************************************************************************************************************************************************************************************************************************************

	private void atualizarJTABLE() {
		List<item> nova = new ArrayList<item>(listaITEM.getListaprincipalitem());
		nova.sort(Comparator.comparing(item::getId));
		for (item cada : nova) {
			ADDitemJTABLE(cada);
		}

	}

//	******************************************************************************************************************************************************************************************************************************************

	private static Object[] criaOBJETO(item recebe) {
		Object[] gravador = new Object[4];
		gravador[0] = recebe.getNome();
		gravador[1] = recebe.getValor();
		gravador[2] = 1;
		gravador[3] = recebe.getId();
		return gravador;

	}
//	******************************************************************************************************************************************************************************************************************************************

	public static Object[] GETcriaOBJETO(item gravador) {
		return criaOBJETO(gravador);
	}

	public static double getTotalPEDIDO() {
		return totalPEDIDO;
	}

	public static void setTotalPEDIDO(double totalPEDIDO) {
		ABRIRPEDIDO.totalPEDIDO = totalPEDIDO;
	}

//	******************************************************************************************************************************************************************************************************************************************

	private Map<Integer, item> criaMAPparaFINALIZARcompra() {
		Map<Integer, item> novomap = new HashMap<>();
		for (int i = 0; i < getModelocarrinho().getRowCount(); i++) {
			String nome = (String) getModelocarrinho().getValueAt(i, 0);
			double valor = (double) getModelocarrinho().getValueAt(i, 1);
			int quantidade = (int) getModelocarrinho().getValueAt(i, 2);
			int id = (int) getModelocarrinho().getValueAt(i, 3);
			item carinha = new item(id, nome, valor, quantidade);
			novomap.put(carinha.getId(), carinha);
			System.out.println("gravamos no pedido final : " + carinha.getNome() + " com ID :" + carinha.getId());

		}
		return novomap;
	}
}
