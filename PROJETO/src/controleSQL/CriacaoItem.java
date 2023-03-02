package controleSQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import telas.item.item;


public class CriacaoItem {

	private boolean criar(item item) {
		
		boolean result = false;
			
		String sql = "INSERT OR IGNORE INTO tbItem "
				+ "("
				+ "NOME,VALOR,QUANTIDADE"
				+ ")"
				+ " VALUES (?,?,?);";
		
		ConexaoBancodeDados conexaoDB = new ConexaoBancodeDados();
		conexaoDB.getConectar();
		PreparedStatement stmt = conexaoDB.getCriarPreparedStatement(sql);
		
		try {
			stmt.setString(1, item.getNome());
			stmt.setDouble(2, item.getValor());
			stmt.setInt(3, item.getQuantidade());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro durante PREPAREDSTATEMENT-inclusao de valores - item");
		}
		
		
		try {
			int resultado = stmt.executeUpdate();
			
			if (resultado == 1) {
				System.out.println("Inseriu o item");
				result = true;
			}
			if (resultado == 0) {
				System.out.println("Não inseriu o item :[");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro durante a criação de Item");
		}finally {
			try {
				stmt.close();
				conexaoDB.getDesconectar();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Erro durante a desconexao - item");
			}
			
		}
		return result;
		
	}
	
	public boolean getCriar(item item) {
		return criar(item);

	}
}
