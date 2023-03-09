package controleSQL;

import controleSQL.criacao.ConexaoBancodeDados;
import controleSQL.criacao.CriacaoTabela;

public class OrdemLeituraDeDadosDB {

	public OrdemLeituraDeDadosDB() {
		new ConexaoBancodeDados().getConectar();
		new CriacaoTabela().criarTodasTabelas();
	}
}
