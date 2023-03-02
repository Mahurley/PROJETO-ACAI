package controleSQL;

import java.sql.Date;

public class TransformaDATE {

	public Date TransformaDATE() {
		Date data;
		String formato = "2023-03-02";
		return data = Date.valueOf(formato);
		
	}
}