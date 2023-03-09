package recursos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransformaStringEmLocalDate {

	public LocalDate DATAcomHORARIO(String data) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDate dataFormatada = LocalDate.parse(data,formato);
		return dataFormatada;
		
	}
	

	
	
}
