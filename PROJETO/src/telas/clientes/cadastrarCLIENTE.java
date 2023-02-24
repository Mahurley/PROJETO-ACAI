package telas.clientes;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import geradorcsv.gravacaoCSV;
import geradorcsv.tipos.tiposCLIENTE;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastrarCLIENTE {

	private JFrame frmCadastrarItem;
	private JTextField textNOME;
	private JTextField textEMAIL;
	private JTextField textTELEFONE;
	private JTextField textDATANASCIMENTO;
	private static JLabel lblRESPOSTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarCLIENTE window = new cadastrarCLIENTE();
					window.frmCadastrarItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cadastrarCLIENTE() {
		initialize();
		new tiposCLIENTE().leitura();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarItem = new JFrame();
		frmCadastrarItem.setResizable(false);
		frmCadastrarItem.setTitle("CADASTRO CLIENTE");
		frmCadastrarItem.setBounds(100, 100, 386, 300);
		frmCadastrarItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("CADASTRAR CLIENTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));

		textNOME = new JTextField();
		textNOME.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("NOME");

		JLabel lblNewLabel_1_1 = new JLabel("EMAIL");

		textEMAIL = new JTextField();
		textEMAIL.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("DATA NASCIMENTO");
		

		JLabel lblNewLabel_1_1_1 = new JLabel("TELEFONE");

		textTELEFONE = new JTextField();
		textTELEFONE.setColumns(10);
		setLblRESPOSTA(new JLabel("AGUARDANDO DADOS PARA CADASTRO..."));

		JButton btnADICIONAR = new JButton("ADICIONAR !");
		btnADICIONAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNOME.getText().isEmpty() | textTELEFONE.getText().isEmpty() | textEMAIL.getText().isEmpty()
						| textNOME.getText().isBlank() | textTELEFONE.getText().isBlank()
						| textEMAIL.getText().isBlank()) {
					getLblRESPOSTA().setText("EXISTE CAMPO VAZIO");

				} else {
					new gravacaoCSV(new tiposCLIENTE(), new cliente(textNOME.getText().toUpperCase(),textDATANASCIMENTO.getText(),textEMAIL.getText(),textTELEFONE.getText()));

					getLblRESPOSTA().setText(String.format("Cliente: %s | Adicionado com sucesso !", textNOME.getText()));
				}

			}
		});
		
		textDATANASCIMENTO = new JTextField();
		textDATANASCIMENTO.setColumns(10);

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
										.addComponent(lblNewLabel_1)))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(textDATANASCIMENTO, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textTELEFONE, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEMAIL, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(getLblRESPOSTA(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnADICIONAR, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textNOME, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_1)
							.addGap(6)
							.addComponent(textEMAIL, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1_1)
						.addComponent(lblNewLabel_1_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textDATANASCIMENTO, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTELEFONE, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnADICIONAR, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getLblRESPOSTA(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		frmCadastrarItem.getContentPane().setLayout(groupLayout);
	}

	public static JLabel getLblRESPOSTA() {
		return lblRESPOSTA;
	}

	public void setLblRESPOSTA(JLabel lblRESPOSTA) {
		cadastrarCLIENTE.lblRESPOSTA = lblRESPOSTA;
	}
}
