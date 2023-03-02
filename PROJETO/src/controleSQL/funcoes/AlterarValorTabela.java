package controleSQL.funcoes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import controleSQL.ConexaoBancodeDados;

public class AlterarValorTabela {
	
	public void executar(TABELA tabela,String coluna,String quantidade1,String referenciaDeBusca,String quantidade2) {


		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();
		
		String sql = "UPDATE tbCliente SET ? = ? WHERE ? = ?;";

		PreparedStatement stmt = conect.getCriarPreparedStatement(sql);
		System.out.println(stmt);
		try {
			//stmt.setString(1, tabela.getCaminho());
			//stmt.setString(2, coluna);
			//stmt.setString(3, quantidade1);
			stmt.setString(4, referenciaDeBusca);
			stmt.setString(5, quantidade2);
			System.out.println(stmt);
			int resultado = stmt.executeUpdate();
			if (resultado == 1) {
				System.out.println("to aqui");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
