package telas.buscapedidos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controleSQL.CriacaoPedido;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class BUSCAPEDIDO extends BUSCAPEDIDO_settings {

	private JFrame frmCONSULTARPEDIDO;
	private JTextField textIDPEDIDO;
	private JTextField textCLIENTE;
	private JTextField textVALORTOTAL;
	private JTextField textDATA;
	private JTextField textFormadePagamento;
	private pedido tipoPEDIDO;
	private JTable tableBUSCAPEDIDO;

	/**
	 * Launch the application.
	 */
	public static void main(String recebeidPEDIDO) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BUSCAPEDIDO window = new BUSCAPEDIDO(recebeidPEDIDO);
					window.frmCONSULTARPEDIDO.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BUSCAPEDIDO(String recebeidPEDIDO) {
		tipoPEDIDO = new CriacaoPedido().buscar(recebeidPEDIDO);
		initialize(tipoPEDIDO);
	}

	private void initialize(pedido recebePEDIDO) {
		frmCONSULTARPEDIDO = new JFrame();
		frmCONSULTARPEDIDO.setResizable(false);
		frmCONSULTARPEDIDO.setTitle("CONSULTA PEDIDO");
		frmCONSULTARPEDIDO.setBounds(100, 100, 732, 320);
		frmCONSULTARPEDIDO.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblBUSCARPEDIDO = new JLabel("CONSULTA PEDIDO");
		lblBUSCARPEDIDO.setHorizontalAlignment(SwingConstants.CENTER);
		lblBUSCARPEDIDO.setFont(new Font("Tahoma", Font.PLAIN, 33));

		textIDPEDIDO = new JTextField();
		textIDPEDIDO.setEnabled(false);
		textIDPEDIDO.setColumns(10);
		

		JLabel lblIDPEDIDO = new JLabel("ID PEDIDO");

		JLabel lblCLIENTE = new JLabel("CLIENTE");

		textCLIENTE = new JTextField();
		textCLIENTE.setEnabled(false);
		textCLIENTE.setColumns(10);
		

		JLabel lblDATA = new JLabel("DATA");
		

		JLabel lblVALORTOTAL = new JLabel("VALOR TOTAL R$");

		textVALORTOTAL = new JTextField();
		textVALORTOTAL.setEnabled(false);
		textVALORTOTAL.setColumns(10);
		
		
		textDATA = new JTextField();
		textDATA.setEnabled(false);
		textDATA.setColumns(10);
		
		
		JLabel lblFORMADEPAGAMENTO = new JLabel("FORMA DE PAGAMENTO");
		
		textFormadePagamento = new JTextField();
		textFormadePagamento.setEnabled(false);
		textFormadePagamento.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(frmCONSULTARPEDIDO.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(10)
										.addComponent(textIDPEDIDO, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblIDPEDIDO)))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblDATA, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(textDATA, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textVALORTOTAL, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lblCLIENTE, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCLIENTE, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lblVALORTOTAL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(lblBUSCARPEDIDO, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFORMADEPAGAMENTO, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFormadePagamento, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblBUSCARPEDIDO)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblIDPEDIDO)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textIDPEDIDO, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCLIENTE)
									.addGap(6)
									.addComponent(textCLIENTE, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblVALORTOTAL)
								.addComponent(lblDATA))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textDATA, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(textVALORTOTAL, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblFORMADEPAGAMENTO)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFormadePagamento, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		tableBUSCAPEDIDO = new JTable();
		tableBUSCAPEDIDO.setModel(getModeloBUSCApedido());
		scrollPane.setViewportView(tableBUSCAPEDIDO);		
		frmCONSULTARPEDIDO.getContentPane().setLayout(groupLayout);
		

//		******************************************************************************************************************************************************************************************************************************************
		textIDPEDIDO.setText(recebePEDIDO.getID());
		textCLIENTE.setText(recebePEDIDO.getCliente().getNome());
		textVALORTOTAL.setText(String.valueOf(recebePEDIDO.getValorTOTAL()));
		textDATA.setText(recebePEDIDO.getData());
		textFormadePagamento.setText(String.valueOf(recebePEDIDO.getFormaDEpagamento()));
//		******************************************************************************************************************************************************************************************************************************************


	}
}