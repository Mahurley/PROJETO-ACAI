package telas;


import controleSQL.funcoes.TransformaDATE;



public class run {

	public static void main(String[] args) {
//		String valor = "14/04/1994".replaceAll("/", "-");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date data = null;
//		try {
//			data = sdf.parse(valor);
//			System.out.println(data.toString());
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		java.sql.Date novo = new TransformaDATE().preparaDateSQL(new TransformaDATE().preparaDateUtil("14-04-1994"));
		
		System.out.println(novo);
		
		
	}

}
