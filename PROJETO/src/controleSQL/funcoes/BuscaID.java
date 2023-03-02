package controleSQL.funcoes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controleSQL.ConexaoBancodeDados;
import telas.clientes.cliente;

public class BuscaID {
	
	
	
	public cliente cliente(int i) {
		
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
	
		conect.getConectar();
		
		String sql = "SELECT * FROM tbCliente WHERE id = 1;";
		
		Statement stmt = conect.getCriarStatement();
		
		try {
			ResultSet resultadoset = stmt.executeQuery(sql);
			cliente cliente = new cliente();
			cliente.setId(resultadoset.getInt("ID"));
			cliente.setNome(resultadoset.getString("NOME"));
			cliente.setTelefone(resultadoset.getString("TELEFONE"));
			cliente.setDatanascimento(resultadoset.getDate("DATA_NASCIMENTO"));
			cliente.setEmail(resultadoset.getString("EMAIL"));
			cliente.setQuantidadePEDIDOS(resultadoset.getInt("QUANTIDADE_PEDIDOS"));
			return cliente;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}
	

}
