package controleSQL.funcoes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import controleSQL.criacao.ConexaoBancodeDados;
import controleSQL.criacao.TABELA;

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
			if (resultado == 0) {
				new SQLException("Erro ao somar quantidade de pedidos - AlterarValorTabela");
			}
		} catch (SQLException e) {
			new SQLException("Erro - AlterarValorTabela");
		}	finally {
			try {
				conect.getDesconectar();
				stmt.close();
			} catch (SQLException e) {
				new SQLException("Erro ao .close - AlterarValorTabela");
			}
			
		}

	}

}
