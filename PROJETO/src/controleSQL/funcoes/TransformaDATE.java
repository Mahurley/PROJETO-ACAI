package controleSQL.funcoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransformaDATE {

	public java.sql.Date preparaDateSQL(java.util.Date recebe) {
		SimpleDateFormat dataantiga = new SimpleDateFormat("yyyy-MM-dd");
		String resultado = dataantiga.format(recebe);
		java.sql.Date datasql = java.sql.Date.valueOf(resultado);
		return datasql;
	}

	public Date preparaDateUtil(String recebe) {
		String nova = StringParaDateSQL(recebe);
		SimpleDateFormat simples = new SimpleDateFormat("yyyy-MM-dd");
		Date datenovo = null;
		try {
			datenovo = simples.parse(nova);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datenovo;

	}

	private String StringParaDateSQL(String dataAntiga) {

		SimpleDateFormat dataAntigaFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date novaData = null;
		try {
			novaData = dataAntigaFormat.parse(dataAntiga);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat dataSQL = new SimpleDateFormat("yyyy-MM-dd");
		String nova = dataSQL.format(novaData);
		return nova;

	}
}