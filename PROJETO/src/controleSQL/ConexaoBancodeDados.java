package controleSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancodeDados {

	private Connection conexao;

	protected boolean conectar() {

		String url = "jdbc:sqlite:DB/teste.db";

		try {
			this.conexao = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		System.out.println("Conexão efetuada com sucesso");
		return true;

	}

	protected boolean desconectar() {
		try {
			if (conexao.isClosed() == false) {
				this.conexao.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		
		System.out.println("Conexão DESCONECTADA");
		return true;

	}


	
}
