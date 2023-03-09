package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import controleSQL.OrdemLeituraDeDadosDB;
import recursos.Calendario;
import recursos.horarioATUALIZADO;
import telas.login.DADOS;
import telas.pedido.AbrirPedido.settings.procurarCELULARlista;
import telas.pedido.PopUpDeJanelas.JanelasMostrarPedidos;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;

public class MAIN {

	JFrame frmPrincipalAcai;

//	******************************************************************************************************************************************************************************************************************************************

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN window = new MAIN();
					window.frmPrincipalAcai.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	******************************************************************************************************************************************************************************************************************************************

	public MAIN() throws IOException {
		new OrdemLeituraDeDadosDB();
		initialize();
	}

//	******************************************************************************************************************************************************************************************************************************************

	private void initialize() {
		frmPrincipalAcai = new JFrame();
		frmPrincipalAcai.setIconImage(Toolkit.getDefaultToolkit().getImage(DADOS.LOGO));
		frmPrincipalAcai.setTitle("PRINCIPAL - LOJA:"+ DADOS.NOME_LOJA);
		frmPrincipalAcai.setBounds(100, 100, 433, 335);
		frmPrincipalAcai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnABRIRPEDIDO = new JButton("ABRIR PEDIDO");
		btnABRIRPEDIDO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcao = JOptionPane.showConfirmDialog(null,
						"CLIENTE GOSTARIA DE SE CADASTRAR PARA TER AS PROMOÇÕES?",
						"CLIENTE COM CADASTRO PARTICIPA DE TODAS AS PROMOÇÕES", JOptionPane.YES_NO_OPTION);
				if (opcao == JOptionPane.YES_OPTION) {
					telas.pedido.cadastrarPEDIDO.main(null);
				} else {
					String celular = JOptionPane.showInputDialog(null, "CELULAR CADASTRADO", "BUSCA CLIENTE CADASTRADO",
							JOptionPane.QUESTION_MESSAGE);

					if (new procurarCELULARlista().procurar(celular)) {
						telas.pedido.AbrirPedido.ABRIRPEDIDO.main(null);
						System.out.println();
					}

				}

			}
		});

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblDATA = new JLabel("................................");
		horarioATUALIZADO.buscar(lblDATA);

//		******************************************************************************************************************************************************************************************************************************************

		JPanel panellogo = new JPanel();

		GroupLayout groupLayout = new GroupLayout(frmPrincipalAcai.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panellogo, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
								.addComponent(lblDATA, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnABRIRPEDIDO, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE).addGap(2)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(panellogo, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblDATA, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(btnABRIRPEDIDO, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
				.addGap(14)));

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblLOGO = new JLabel(new ImageIcon(DADOS.LOGO));
		lblLOGO.setVerticalAlignment(SwingConstants.TOP);
		panellogo.add(lblLOGO);
		frmPrincipalAcai.getContentPane().setLayout(groupLayout);
		JMenuBar menuBar = new JMenuBar();
		frmPrincipalAcai.setJMenuBar(menuBar);

//		******************************************************************************************************************************************************************************************************************************************

		JMenu mnNewMenu = new JMenu("PRODUTOS");
		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnNewMenu);

//		******************************************************************************************************************************************************************************************************************************************

		JButton buttomCADASTRAR = new JButton("CADASTRO NOVO");
		buttomCADASTRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telas.item.cadastrarITEM.main(null);
			}
		});

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnListaDeProdutos = new JButton("LISTA PRODUTOS");
		btnListaDeProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telas.item.listaprodutos.main(null);
			}
		});
		mnNewMenu.add(btnListaDeProdutos);
		mnNewMenu.add(buttomCADASTRAR);

//		******************************************************************************************************************************************************************************************************************************************

		JMenu mnClientes = new JMenu("CLIENTES");
		mnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnClientes);

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnCONSULTARCLIENTE = new JButton("CONSULT CLIENTE");
		mnClientes.add(btnCONSULTARCLIENTE);

//		******************************************************************************************************************************************************************************************************************************************

		JButton buttomCADASTRARCLIENTE = new JButton("CADASTRO NOVO");
		buttomCADASTRARCLIENTE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telas.clientes.cadastrarCLIENTE.main(null);
			}
		});
		mnClientes.add(buttomCADASTRARCLIENTE);

//		******************************************************************************************************************************************************************************************************************************************

		JMenu mnPEDIDOS = new JMenu("PEDIDOS");
		mnPEDIDOS.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnPEDIDOS);

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnConsultPedidos = new JButton("CONSULTA PEDIDOS");
		btnConsultPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String IDpedido = JOptionPane.showInputDialog(null, "ID PEDIDO", "BUSCA PEDIDO - ID",
						JOptionPane.QUESTION_MESSAGE);
				if(IDpedido == null || IDpedido.isBlank()){
					new InputMismatchException("Campo vazio");
				}else {
					telas.pedido.BuscaPedido.BUSCAPEDIDO.main(IDpedido);
					
				}
				System.out.println("pasei aqui");
			}
		});
		mnPEDIDOS.add(btnConsultPedidos);

		JButton btnProcuraPdata = new JButton("CONSULTA POR MES");
		btnProcuraPdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] CALENDARIO = new Calendario().gerandoCalendario();
				List<String> LISTAcomPEDIDOS = new JanelasMostrarPedidos().JanelaMES(CALENDARIO,"CONSULTA PEDIDOS POR MES",JOptionPane.YES_NO_OPTION);
				System.out.println(LISTAcomPEDIDOS);
				new JanelasMostrarPedidos().JanelaPEDIDOS(LISTAcomPEDIDOS);
					

				}

			
		});
		mnPEDIDOS.add(btnProcuraPdata);
		
		JButton btnProcuraPorTel = new JButton("CONSULTA POR TEL");
		btnProcuraPorTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<String> listaCOMpedidos = new JanelasMostrarPedidos().JanelaTELEFONE("CONSULTA PEDIDO POR TELEFONE", JOptionPane.INFORMATION_MESSAGE);
				
				new JanelasMostrarPedidos().JanelaPEDIDOStelefone(listaCOMpedidos);
			}
		});
		mnPEDIDOS.add(btnProcuraPorTel);

//		******************************************************************************************************************************************************************************************************************************************

}

}
