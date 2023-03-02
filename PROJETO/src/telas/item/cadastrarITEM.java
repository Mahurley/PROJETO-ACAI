package telas.item;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controleSQL.CriacaoItem;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cadastrarITEM {

	private JFrame frmCadastrarItem;
	private JTextField textNOME;
	private JTextField textPRECO;
	private JTextField textESTOQUE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarITEM window = new cadastrarITEM();
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
	public cadastrarITEM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarItem = new JFrame();
		frmCadastrarItem.setResizable(false);
		frmCadastrarItem.setTitle("CADASTRAR PRODUTO");
		frmCadastrarItem.setBounds(100, 100, 386, 300);
		frmCadastrarItem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("CADASTRAR PRODUTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));

		textNOME = new JTextField();
		textNOME.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("NOME DO PRODUTO");

		JLabel lblNewLabel_1_1 = new JLabel("PREÇO");

		textPRECO = new JTextField();
		textPRECO.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("CATEGORIA");

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "BEBIDAS", "COMPLEMENTOS", "ADICIONAIS", "COMBO" }));
		

		JLabel lblNewLabel_1_1_1 = new JLabel("CONTROLE DE ESTOQUE");

		textESTOQUE = new JTextField();
		textESTOQUE.setColumns(10);
		JLabel lblRESPOSTA = new JLabel("AGUARDANDO DADOS PARA CADASTRO...");

		JButton btnADICIONAR = new JButton("ADICIONAR !");
		btnADICIONAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNOME.getText().isEmpty() | textESTOQUE.getText().isEmpty() | textPRECO.getText().isEmpty()
						| textNOME.getText().isBlank() | textESTOQUE.getText().isBlank()
						| textPRECO.getText().isBlank()) {
					lblRESPOSTA.setText("EXISTE CAMPO VAZIO");

				} else {
					int recebe = comboBox.getSelectedIndex();
					new CriacaoItem().getCriar(new item(textNOME.getText().toUpperCase(),Integer.valueOf(textPRECO.getText()),Integer.valueOf(textESTOQUE.getText())));
					lblRESPOSTA.setText(String.format("Item: %s | Adicionado com sucesso !", textNOME.getText()));
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(frmCadastrarItem.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup().addContainerGap()
												.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(textNOME,
												GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addContainerGap()
												.addComponent(lblNewLabel_1)))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(
										lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textESTOQUE, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 99,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textPRECO, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup().addGap(61)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblRESPOSTA, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnADICIONAR, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233,
												Short.MAX_VALUE))))
				.addContainerGap(11, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(20).addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textNOME, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_1_1).addGap(6)
								.addComponent(textPRECO, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_1_2)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(comboBox,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_1_1_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textESTOQUE, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnADICIONAR, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblRESPOSTA, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(14, Short.MAX_VALUE)));
		frmCadastrarItem.getContentPane().setLayout(groupLayout);
	}
}
