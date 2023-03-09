package controleSQL.criacao;

import java.sql.SQLException;
import java.sql.Statement;

public class CriacaoTabela {

	private boolean tbCliente() {
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();

		String sql = "CREATE TABLE IF NOT EXISTS tbCliente" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "NOME TEXT NOT NULL UNIQUE," + "DATA_NASCIMENTO DATE NOT NULL," + "EMAIL TEXT,"
				+ "TELEFONE TEXT NOT NULL UNIQUE," + "QUANTIDADE_PEDIDOS INTEGER" + ");";

		Statement stmt = conect.getCriarStatement();

		try {
			if (stmt.execute(sql)) {
				System.out.println("Tabela cliente - criada");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.err.println("Erro ao criar table");
		} finally {

			try {
				stmt.close();
				conect.getDesconectar();
				return true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.err.println("Erro .close table");
			}
		}
		return false;

	}
	
	private boolean tbItem() {
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();
		
		String sql = "CREATE TABLE IF NOT EXISTS tbItem("
				+ "ID INTEGER PRIMARY KEY UNIQUE,"
				+ "NOME TEXT UNIQUE NOT NULL,"
				+ "VALOR NUMERIC,"
				+ "QUANTIDADE INTEGER NOT NULL"
				+ ");";
		
		
		Statement stmt = conect.getCriarStatement();		
		try {
			if (stmt.execute(sql)) {
				System.out.println("Tabela criada - Item");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.err.println("Erro abrir table Item");
		}finally {
			
			try {
				stmt.close();
				conect.getDesconectar();
				return true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.err.println("Erro .close table Item");
			}
		}
		return false;
	}
	
	private boolean tbPedido() {
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();
		
		String sql = "CREATE TABLE IF NOT EXISTS tbPedido("
				+ "ID TEXT PRIMARY KEY NOT NULL UNIQUE,"
				+ "ID_CLIENTE INTEGER NOT NULL REFERENCES tbCliente (ID) ON UPDATE SET DEFAULT,"
				+ "FORMA_DE_PAGAMENTO TEXT NOT NULL,"
				+ "VALORTOTAL REAL NOT NULL,"
				+ "ITEM_PEDIDO TEXT NOT NULL,"
				+ "DATA TIMESTAMP NOT NULL"
				+ ");";
		
		Statement stmt = conect.getCriarStatement();
		
		try {
			if (stmt.execute(sql)) {
				System.out.println("Tabela criada - Pedido");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.err.println("Erro criar table Pedido");
		}finally {
			try {
				stmt.close();
				conect.getDesconectar();
				return true;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.err.println("Erro .close table Pedido");
			}
		}
		return false;
	}
	
	
	
	public void criarTodasTabelas() {
		tabelaPedido();
		tabelaItem();
		tabelaPedido();
	}
	
	
	public boolean tabelaPedido() {
		return tbPedido();
	}

	public boolean tabelaItem() {
		return tbItem();
	}

	public boolean tabelaCliente() {
		return tbCliente();

	}

}
