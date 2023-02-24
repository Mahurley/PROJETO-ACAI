package recursos;

public class Calendario {
	
	public String[] gerandoCalendario() {
		String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
				"Setembro", "Outubro", "Novembro", "Dezembro" };
		String[][] datas = new String[13][32];
		int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int mes = 0; mes < meses.length; mes++) {
			for (int dia = 1; dia <= diasPorMes[mes]; dia++) {
				String novodia = String.valueOf(dia);
				String novomes = String.valueOf(mes + 1);
				if (dia < 10) {
					novodia = "0" + dia;
				}
				if (mes < 10) {
					novomes = "0" + mes;
				}
				String dataSTRING = novodia + "/" + novomes + "\n";
				datas[mes][dia] = dataSTRING;
			}
		}

		return meses;
	}

}
