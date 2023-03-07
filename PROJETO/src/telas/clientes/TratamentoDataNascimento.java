package telas.clientes;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class TratamentoDataNascimento {
	
	public TratamentoDataNascimento(DocumentEvent e, JTextField textDATANASCIMENTO) {
		
		verificaLimiteTamanhoDataNascimento(e);
		inclusaoDeBarrasDIAeMES(e,textDATANASCIMENTO);
		
		
		
	}
	
	private void verificaLimiteTamanhoDataNascimento(DocumentEvent e) {
		if (e.getDocument().getLength() > 10) {
			Document doc = e.getDocument();
			SwingUtilities.invokeLater(() -> {
				try {
					doc.remove(e.getDocument().getLength()-1, 1);
				} catch (BadLocationException e1) {
					System.out.println(e1.getMessage());
					System.out.println("Erro ao verificar tamanho maximo DataNascimento");
					}
			});
			return;
		}
		
	}

	private void inclusaoDeBarrasDIAeMES(DocumentEvent e, JTextField textDATANASCIMENTO) {
		if (e.getDocument().getLength() == 3 ||e.getDocument().getLength() == 6) {
			char ultimochar = textDATANASCIMENTO.getText().charAt(textDATANASCIMENTO.getDocument().getLength()-1);
			String charstring = String.valueOf(ultimochar);
			if (charstring.compareTo("/") != 0) { 
				String texto = textDATANASCIMENTO.getText()+" ";
					char[] novochar = texto.toCharArray();
					novochar[texto.length()-1] = novochar[texto.length()-2];
					novochar[texto.length()-2] = '/';
				String novotextoatualizado = String.valueOf(novochar);
				SwingUtilities.invokeLater(() -> textDATANASCIMENTO.setText(novotextoatualizado));
			}
			
		}
		
		if (e.getDocument().getLength() == 2 || e.getDocument().getLength() == 5) {
			try {
				String escrita = textDATANASCIMENTO.getText(0, textDATANASCIMENTO.getDocument().getLength()) + "/";
			
				SwingUtilities.invokeLater(() -> textDATANASCIMENTO.setText(escrita));
				
				
			} catch (BadLocationException e1) {
				System.out.println(e1.getMessage());
				System.out.println("Erro ao incluir texto atualizado Data Nascimento");
			}
		}

	}
}
