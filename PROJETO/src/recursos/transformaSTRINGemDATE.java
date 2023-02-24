package recursos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class transformaSTRINGemDATE {

	public LocalDate transformarDATAcomHORARIO(String data) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDate dataFormatada = LocalDate.parse(data,formato);
		return dataFormatada;
		
	}
	

	
	
}
