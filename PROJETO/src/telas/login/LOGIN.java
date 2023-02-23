package telas.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Toolkit;

public class LOGIN extends JFrame implements DADOS {

//	******************************************************************************************************************************************************************************************************************************************

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLOGIN;
	private JPasswordField textSENHA;

//	******************************************************************************************************************************************************************************************************************************************

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN frame = new LOGIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	******************************************************************************************************************************************************************************************************************************************

	public LOGIN() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("aqui5.png"));
		setTitle("LOGIN - ACAI CHEIO DE DOCURA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 192, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		
//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblNewLabel = new JLabel("SEJA BEM VINDO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));

		textLOGIN = new JTextField();
		textLOGIN.setColumns(10);
		
//		******************************************************************************************************************************************************************************************************************************************


		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 19));
		
//		******************************************************************************************************************************************************************************************************************************************


		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 19));

		textSENHA = new JPasswordField();

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnNewButton = new JButton("Confirmar");
		contentPane.setLayout(new MigLayout("", "[156px][1px]", "[23px][23px][28px][23px][28px][23px][1px][][]"));
		contentPane.add(textSENHA, "cell 0 4,grow");
		contentPane.add(lblNewLabel, "cell 0 0,alignx right,aligny top");
		contentPane.add(lblSenha, "cell 0 3,alignx center,aligny top");
		contentPane.add(textLOGIN, "cell 0 2,grow");
		contentPane.add(lblLogin, "cell 0 1,alignx center,aligny top");
		contentPane.add(btnNewButton, "cell 0 5,alignx center,aligny top");
		
//		******************************************************************************************************************************************************************************************************************************************


		JLabel labelRESPOSTA = new JLabel("AGUARDANDO LOGIN...");
		contentPane.add(labelRESPOSTA, "cell 0 8,alignx center,aligny top");
		
//		******************************************************************************************************************************************************************************************************************************************


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textLOGIN.getText().compareTo(DADOS.LOGIN) == 0
						& String.copyValueOf(textSENHA.getPassword()).compareTo(DADOS.SENHA) == 0) {
					labelRESPOSTA.setText("LOGIN APROVADO");
					System.out.println("LOGIN CORRETO");
					System.out.println("SENHA CORRETO");
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					telas.PRINCIPAL.main(null);
					dispose();
				} else {
					labelRESPOSTA.setText("LOGIN/SENHA INCORRETO");
				}

			}
		});
		
//		******************************************************************************************************************************************************************************************************************************************

	}
}
