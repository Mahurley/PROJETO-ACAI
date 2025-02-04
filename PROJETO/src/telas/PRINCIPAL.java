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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import geradorcsv.tipos.tiposARQUIVOS;
import recursos.horarioATUALIZADO;
import telas.abrirpedido.settings.procurarCELULARlista;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;

public class PRINCIPAL {

	JFrame frmPrincipalAcai;


//	******************************************************************************************************************************************************************************************************************************************

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PRINCIPAL window = new PRINCIPAL();
					window.frmPrincipalAcai.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	******************************************************************************************************************************************************************************************************************************************

	public PRINCIPAL() throws IOException {
		tiposARQUIVOS.verificarTODOScsv();
		tiposARQUIVOS.leituraTODOScsv();
		
		initialize();
	}
	
//	******************************************************************************************************************************************************************************************************************************************

	private void initialize() {
		frmPrincipalAcai = new JFrame();
		frmPrincipalAcai.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\aqui.png"));
		frmPrincipalAcai.setTitle("PRINCIPAL - ACAI CHEIO DE DOCURA");
		frmPrincipalAcai.setBounds(100, 100, 433, 335);
		frmPrincipalAcai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		******************************************************************************************************************************************************************************************************************************************

		JButton btnABRIRPEDIDO = new JButton("ABRIR PEDIDO");
		btnABRIRPEDIDO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = JOptionPane.showConfirmDialog(null, "CLIENTE GOSTARIA DE SE CADASTRAR PARA TER AS PROMOÇÕES?", "CLIENTE COM CADASTRO PARTICIPA DE TODAS AS PROMOÇÕES", JOptionPane.YES_NO_OPTION);
			if (opcao == JOptionPane.YES_OPTION) {
				telas.abrirpedido.cadastrarPEDIDO.main(null);
				}else {
					String celular = JOptionPane.showInputDialog(null,"CELULAR CADASTRADO","BUSCA CLIENTE CADASTRADO", JOptionPane.QUESTION_MESSAGE);
					
					if (new procurarCELULARlista().procurar(celular)) {
						telas.abrirpedido.ABRIRPEDIDO.main(null);
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
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panellogo, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(lblDATA, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnABRIRPEDIDO, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
					.addGap(2))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panellogo, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblDATA, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(btnABRIRPEDIDO, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
			
//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblLOGO = new JLabel(new ImageIcon("aqui5.png"));
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
				telas.produtos.cadastrar.main(null);
			}
		});

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnListaDeProdutos = new JButton("LISTA PRODUTOS");
		btnListaDeProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telas.produtos.listaprodutos.main(null);
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
				telas.clientes.cadastrar.main(null);
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
				
				String IDpedido = JOptionPane.showInputDialog(null,"ID PEDIDO","BUSCA PEDIDO - ID", JOptionPane.QUESTION_MESSAGE);
				telas.buscapedidos.consultaPEDIDO.main(IDpedido);
			}
		});
		mnPEDIDOS.add(btnConsultPedidos);
		
//		******************************************************************************************************************************************************************************************************************************************

	}

}
