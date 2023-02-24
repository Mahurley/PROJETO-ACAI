package telas.abrirpedido;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import recursos.timerSEGUNDOS;
import telas.clientes.cliente;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import geradorcsv.gravacaoCSV;
import geradorcsv.tipos.tiposCLIENTE;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastrarPEDIDO {

	private JFrame frmCadastrarItem;
	private JTextField textNOME;
	private JTextField textEMAIL;
	private JTextField textTELEFONE;
	private JTextField textDATANASCIMENTO;

//	******************************************************************************************************************************************************************************************************************************************

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarPEDIDO window = new cadastrarPEDIDO();
					window.frmCadastrarItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	******************************************************************************************************************************************************************************************************************************************

	public cadastrarPEDIDO() {
		initialize();
		//tiposARQUIVOS.leituraTODOScsv();

	}

//	******************************************************************************************************************************************************************************************************************************************

	private void initialize() {
		frmCadastrarItem = new JFrame();
		frmCadastrarItem.setResizable(false);
		frmCadastrarItem.setTitle("CADASTRO CLIENTE");
		frmCadastrarItem.setBounds(100, 100, 386, 300);
		frmCadastrarItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblCADASTRARCLIENTE = new JLabel("CADASTRAR CLIENTE");
		lblCADASTRARCLIENTE.setHorizontalAlignment(SwingConstants.CENTER);
		lblCADASTRARCLIENTE.setFont(new Font("Tahoma", Font.PLAIN, 33));

		textNOME = new JTextField();
		textNOME.setColumns(10);

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblNOME = new JLabel("NOME");

//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblEMAIL = new JLabel("EMAIL");

		textEMAIL = new JTextField();
		textEMAIL.setColumns(10);
//		******************************************************************************************************************************************************************************************************************************************


		JLabel lblDATANASCIMENTO = new JLabel("DATA NASCIMENTO");
		textDATANASCIMENTO = new JTextField();
		textDATANASCIMENTO.setColumns(10);
		
//		******************************************************************************************************************************************************************************************************************************************


		JLabel lblTELEFONE = new JLabel("TELEFONE");
		textTELEFONE = new JTextField();
		textTELEFONE.setColumns(10);
		JLabel lblRESPOSTA = new JLabel("AGUARDANDO DADOS PARA CADASTRO...");
		
//		******************************************************************************************************************************************************************************************************************************************


		JButton btnADICIONAR = new JButton("ADICIONAR !");
		btnADICIONAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNOME.getText().isEmpty() | textTELEFONE.getText().isEmpty() | textEMAIL.getText().isEmpty()| textDATANASCIMENTO.getText().isEmpty()
						| textNOME.getText().isBlank() | textTELEFONE.getText().isBlank()
						| textEMAIL.getText().isBlank()| textDATANASCIMENTO.getText().isBlank()) {
					lblRESPOSTA.setText("EXISTE CAMPO VAZIO");

				} else {
					cliente clientegerado = new cliente(textNOME.getText().toUpperCase(),textDATANASCIMENTO.getText(),textEMAIL.getText(),textTELEFONE.getText());
					new gravacaoCSV(new tiposCLIENTE(), clientegerado);

					lblRESPOSTA.setText(String.format("Cliente: %s | Adicionado com sucesso !", textNOME.getText()));
					ABRIRPEDIDO_settings.setCLIENTEachado(clientegerado);
					new timerSEGUNDOS(2000);
					frmCadastrarItem.dispose();
					telas.abrirpedido.ABRIRPEDIDO.main(null);
				}

			}
		});
//		******************************************************************************************************************************************************************************************************************************************
		GroupLayout groupLayout = new GroupLayout(frmCadastrarItem.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(10)
										.addComponent(textNOME, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNOME)))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblDATANASCIMENTO, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(textDATANASCIMENTO, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textTELEFONE, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lblEMAIL, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEMAIL, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lblTELEFONE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(lblCADASTRARCLIENTE, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblRESPOSTA, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnADICIONAR, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCADASTRARCLIENTE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNOME)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNOME, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEMAIL)
							.addGap(6)
							.addComponent(textEMAIL, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTELEFONE)
						.addComponent(lblDATANASCIMENTO))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textDATANASCIMENTO, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTELEFONE, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnADICIONAR, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRESPOSTA, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		frmCadastrarItem.getContentPane().setLayout(groupLayout);
	}
	
//	******************************************************************************************************************************************************************************************************************************************


}
