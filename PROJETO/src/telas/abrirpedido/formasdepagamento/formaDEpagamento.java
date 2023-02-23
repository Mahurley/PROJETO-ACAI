package telas.abrirpedido.formasdepagamento;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import geradorcsv.gravacaoCSV;
import geradorcsv.tipos.tiposPEDIDO;
import telas.abrirpedido.ABRIRPEDIDO;
import telas.abrirpedido.ABRIRPEDIDO_settings;
import telas.abrirpedido.settings.CRIANDOPEDIDOformadePAGAMENTO;
import telas.buscapedidos.pedido;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class formaDEpagamento extends ABRIRPEDIDO_settings {

	private JFrame frmFormaDePagamento;
	public static pedido novopedido;

	/**
	 * Launch the application.
	 */
	public static void main(pedido recebimento) {
		novopedido = recebimento;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formaDEpagamento window = new formaDEpagamento();
					window.frmFormaDePagamento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public formaDEpagamento() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFormaDePagamento = new JFrame();
		frmFormaDePagamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFormaDePagamento.setTitle("FORMA DE PAGAMENTO");
		frmFormaDePagamento.setResizable(false);
		frmFormaDePagamento.setBounds(100, 100, 476, 300);
		SpringLayout springLayout = new SpringLayout();
		frmFormaDePagamento.getContentPane().setLayout(springLayout);
		
		
//		******************************************************************************************************************************************************************************************************************************************
		
		JButton btnDINHEIRO = new JButton("DINHEIRO");
		springLayout.putConstraint(SpringLayout.WEST, btnDINHEIRO, 9, SpringLayout.WEST, frmFormaDePagamento.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnDINHEIRO, -158, SpringLayout.SOUTH, frmFormaDePagamento.getContentPane());
		btnDINHEIRO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CRIANDOPEDIDOformadePAGAMENTO(PAGAMENTOS.DINHEIRO, novopedido);
				new gravacaoCSV(new tiposPEDIDO(), novopedido);
				frmFormaDePagamento.dispose();
				ABRIRPEDIDO.frmAberturaDeVenda.dispose();
			}
			
		});
		ImageIcon novo = new ImageIcon("C:\\Users\\User\\Desktop\\formas de pagamento\\dinheiro.png");
		Image image = novo.getImage();
		Image nova = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		btnDINHEIRO.setIcon(new ImageIcon(nova));
		frmFormaDePagamento.getContentPane().add(btnDINHEIRO);
		
		
//		******************************************************************************************************************************************************************************************************************************************
		
		
		
		JButton btnCARTAOCREDITO = new JButton("CREDITO");
		springLayout.putConstraint(SpringLayout.NORTH, btnDINHEIRO, 0, SpringLayout.NORTH, btnCARTAOCREDITO);
		springLayout.putConstraint(SpringLayout.EAST, btnDINHEIRO, -6, SpringLayout.WEST, btnCARTAOCREDITO);
		springLayout.putConstraint(SpringLayout.WEST, btnCARTAOCREDITO, 158, SpringLayout.WEST, frmFormaDePagamento.getContentPane());
		btnCARTAOCREDITO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CRIANDOPEDIDOformadePAGAMENTO(PAGAMENTOS.CARTAO_CREDITO, novopedido);
				new gravacaoCSV(new tiposPEDIDO(), novopedido);
				frmFormaDePagamento.dispose();
				ABRIRPEDIDO.frmAberturaDeVenda.dispose();
			}
		});
		btnCARTAOCREDITO.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\formas de pagamento\\CARTAO.png"));
		
		ImageIcon novo2 = new ImageIcon("C:\\Users\\User\\Desktop\\formas de pagamento\\CARTAO.png");
		Image image2 = novo2.getImage();
		Image nova2 = image2.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		btnCARTAOCREDITO.setIcon(new ImageIcon(nova2));
		frmFormaDePagamento.getContentPane().add(btnCARTAOCREDITO);
		
		
//		******************************************************************************************************************************************************************************************************************************************
		
		JLabel lblTOTALFINAL = getlblTOTAL();
		lblTOTALFINAL.setFont(new Font("Tahoma", Font.PLAIN, 19));
		springLayout.putConstraint(SpringLayout.NORTH, lblTOTALFINAL, 21, SpringLayout.SOUTH, btnDINHEIRO);
		springLayout.putConstraint(SpringLayout.WEST, lblTOTALFINAL, 0, SpringLayout.WEST, btnDINHEIRO);
		frmFormaDePagamento.getContentPane().add(lblTOTALFINAL);
		
		
//		******************************************************************************************************************************************************************************************************************************************
		
		JButton btnCARTAODEBITO = new JButton("DEBITO");
		btnCARTAODEBITO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CRIANDOPEDIDOformadePAGAMENTO(PAGAMENTOS.CARTAO_DEBITO, novopedido);
				new gravacaoCSV(new tiposPEDIDO(), novopedido);
				frmFormaDePagamento.dispose();
				ABRIRPEDIDO.frmAberturaDeVenda.dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnCARTAOCREDITO, 0, SpringLayout.NORTH, btnCARTAODEBITO);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCARTAOCREDITO, 0, SpringLayout.SOUTH, btnCARTAODEBITO);
		springLayout.putConstraint(SpringLayout.EAST, btnCARTAOCREDITO, -6, SpringLayout.WEST, btnCARTAODEBITO);
		springLayout.putConstraint(SpringLayout.NORTH, btnCARTAODEBITO, 24, SpringLayout.NORTH, frmFormaDePagamento.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCARTAODEBITO, -158, SpringLayout.SOUTH, frmFormaDePagamento.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCARTAODEBITO, 307, SpringLayout.WEST, frmFormaDePagamento.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCARTAODEBITO, -10, SpringLayout.EAST, frmFormaDePagamento.getContentPane());
	
		ImageIcon novo3 = new ImageIcon("C:\\Users\\User\\Desktop\\formas de pagamento\\CARTAO.png");
		Image image3 = novo3.getImage();
		Image nova3 = image3.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		btnCARTAODEBITO.setIcon(new ImageIcon(nova3));
		frmFormaDePagamento.getContentPane().add(btnCARTAODEBITO);
		
		
//		******************************************************************************************************************************************************************************************************************************************
	}
}
