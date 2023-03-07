package controleSQL.funcoes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import controleSQL.ConexaoBancodeDados;

public class AlterarValorTabela {

	public void executar(TABELA tabela, String coluna, int quantidade1, String referenciaDeBusca,int quantidade2) {

		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();
		String sql = String.format("UPDATE %s SET %s = ? WHERE %s = ? ;", tabela.getCaminho(),coluna,referenciaDeBusca);
		PreparedStatement stmt = conect.getCriarPreparedStatement(sql);
		try {
			stmt.setInt(1, quantidade1);
			stmt.setInt(2, quantidade2);
			
			int resultado = stmt.executeUpdate();
			if (resultado == 1) {
				System.out.println("Adicionado quantidade de pedidos ao cliente em +1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
