package controleSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBancodeDados {

	private Connection conexao;

	private boolean conectar() {

		String url = "jdbc:sqlite:DB/BANCO.db";

		try {
			this.conexao = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		System.out.println("Conexão efetuada com sucesso");
		return true;

	}

	private boolean desconectar() {
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
	
	private Statement criarStatement() {
		try {
			return this.conexao.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao criar Statement");
			return null;
		}
	}

	private PreparedStatement criarPreparedStatement(String sql) {
		try {
			return this.conexao.prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Deu erro na criacao de preparedStatement");
			return null;
		}
		
	}

	
	public boolean getConectar() {
		return conectar();

	}
	
	public boolean getDesconectar() {
		return desconectar();
	}
	
	public Statement getCriarStatement() {
		return criarStatement();
	}
	
	public PreparedStatement getCriarPreparedStatement(String sql) {
		return criarPreparedStatement(sql);
	}
}
