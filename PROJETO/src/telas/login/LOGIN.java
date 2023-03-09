package telas.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(DADOS.LOGO));
		setTitle("LOGIN - "+ DADOS.NOME_LOJA);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 434, 278);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		
//		******************************************************************************************************************************************************************************************************************************************

		JLabel lblNewLabel = new JLabel("SEJA BEM VINDO AO "+ DADOS.NOME_LOJA);
		lblNewLabel.setBounds(10, 203, 398, 27);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		
//		******************************************************************************************************************************************************************************************************************************************


		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(337, 11, 71, 27);
		lblLogin.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));

//		******************************************************************************************************************************************************************************************************************************************

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(226, 130, 182, 27);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblLogin);
				
						textLOGIN = new JTextField();
						textLOGIN.setBounds(226, 38, 182, 27);
						textLOGIN.setColumns(10);
						contentPane.add(textLOGIN);
				
//		******************************************************************************************************************************************************************************************************************************************


				JLabel lblSenha = new JLabel("SENHA");
				lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
				lblSenha.setBounds(337, 65, 71, 27);
				lblSenha.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
				contentPane.add(lblSenha);
		
				textSENHA = new JPasswordField();
				textSENHA.setBounds(226, 92, 182, 27);
				contentPane.add(textSENHA);
		contentPane.add(btnNewButton);
		
//		******************************************************************************************************************************************************************************************************************************************


		JLabel labelRESPOSTA = new JLabel("AGUARDANDO LOGIN...");
		labelRESPOSTA.setHorizontalAlignment(SwingConstants.CENTER);
		labelRESPOSTA.setBounds(226, 168, 182, 27);
		contentPane.add(labelRESPOSTA);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 203, 408, 27);
		contentPane.add(label);
		
		JPanel panellogo = new JPanel();
		panellogo.setBackground(new Color(255, 255, 255));
		panellogo.setBounds(0, 0, 224, 192);
		contentPane.add(panellogo);
		
		ImageIcon imageicon = new ImageIcon(DADOS.LOGO);
		Image imagem = imageicon.getImage()
;		Image imagemscalada = imagem.getScaledInstance(195, 195, Image.SCALE_SMOOTH);
		JLabel lblLOGO = new JLabel(new ImageIcon(imagemscalada));
		//lblLOGO.setVerticalAlignment(SwingConstants.CENTER);
		panellogo.add(lblLOGO);
		//lblLOGO.setHorizontalAlignment(JLabel.CENTER);
		//lblLOGO.setVerticalAlignment(JLabel.CENTER);
		//lblLOGO.setPreferredSize(new Dimension(200, 200));
		
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
					telas.MAIN.main(null);
					dispose();
				} else {
					labelRESPOSTA.setText("LOGIN/SENHA INCORRETO");
				}

			}
		});
		
//		******************************************************************************************************************************************************************************************************************************************

	}
}
