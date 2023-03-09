package controleSQL.criacao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controleSQL.funcoes.TransformaDATE;
import telas.clientes.cliente;

public class CriacaoCliente {
	
	private boolean criar(cliente cliente) {
		boolean result = false;
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();
		
		String sql = "INSERT OR IGNORE INTO tbCliente "
				+ "(NOME,DATA_NASCIMENTO,EMAIL,TELEFONE,QUANTIDADE_PEDIDOS)"
				+ " VALUES "
				+ "(?,?,?,?,?);";
		
		PreparedStatement stmt = conect.getCriarPreparedStatement(sql);
		
		try {
			stmt.setString(1, cliente.getNome());
			stmt.setDate(2, new TransformaDATE().preparaDateSQL(cliente.getDatanascimento()));
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.setInt(5, cliente.getQuantidadePEDIDOS());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro no PREPAREDSTATEMENT - inclusao de dados - cliente");
		}
	
		try {
			int resultado = stmt.executeUpdate();
			if (resultado == 1) {
				System.out.println("Cliente inserido !");
				result =  true;
			}
			if (resultado == 0) {
				System.out.println("Erro cliente nao inserido !");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro para inserir - cliente");
		}finally {
			try {
				stmt.close();
				conect.getDesconectar();
				System.out.println("Tudo closed");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Erro no fechamento de .close - cliente");
			}
		}
		
		return result;
	}
	
	public boolean getCriar(cliente cliente) {
		return criar(cliente);

	}

}
