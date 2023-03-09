package controleSQL.funcoes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controleSQL.criacao.ConexaoBancodeDados;
import telas.clientes.cliente;

public class ProcurarID {
	
	
	
	public cliente cliente(String ColunaDeReferencia,String valorreferencia2) {
		
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		cliente cliente = new cliente();
		conect.getConectar();
		ResultSet resultadoset= null;
		
		String sql = "SELECT * FROM tbCliente WHERE "+ColunaDeReferencia+" = ? ;";
		
		PreparedStatement stmt = conect.getCriarPreparedStatement(sql);
		
		try {
			stmt.setString(1, valorreferencia2);
		} catch (SQLException e1) {
			System.out.println("Erro selecionar - ProcurarID");
			System.out.println(e1.getMessage());
		}
		
		
		try {
			
			resultadoset = stmt.executeQuery();
			
			cliente.setId(resultadoset.getInt("ID"));
			cliente.setNome(resultadoset.getString("NOME"));
			cliente.setTelefone(resultadoset.getString("TELEFONE"));
			cliente.setDatanascimento(resultadoset.getDate("DATA_NASCIMENTO"));
			cliente.setEmail(resultadoset.getString("EMAIL"));
			cliente.setQuantidadePEDIDOS(resultadoset.getInt("QUANTIDADE_PEDIDOS"));
			
		} catch (SQLException e) {
			System.out.println("Erro executar - ProcurarID");
			System.out.println(e.getMessage());
		}finally {
			
			try {
				conect.getDesconectar();
				stmt.close();
				resultadoset.close();
			} catch (SQLException e) {
				System.out.println("Erro .close - ProcurarID");
				System.out.println(e.getMessage());
			}
		}
		return cliente;

	}
	

}
