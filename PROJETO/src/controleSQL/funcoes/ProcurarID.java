package controleSQL.funcoes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controleSQL.ConexaoBancodeDados;
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				conect.getDesconectar();
				stmt.close();
				resultadoset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cliente;

	}
	

}
