package recursos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class horarioATUALIZADO {
	
	public static void buscar(JLabel entrando) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Timer contador = new Timer(1000, new ActionListener() {
		   @Override
		   public void actionPerformed(ActionEvent e) {
		      String dataCompleta = dateFormat.format(new Date());
		      entrando.setText(dataCompleta);
		   }
		});
		contador.start();
	}
	
	

}
