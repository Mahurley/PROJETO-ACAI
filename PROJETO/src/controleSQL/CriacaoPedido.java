package controleSQL;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import telas.buscapedidos.pedido;

public class CriacaoPedido {
	
	private boolean criar(pedido pedido) {
		boolean result = false;
		
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.conectar();
		
		String sql = "INSERT OR IGNORE INTO tbPedido "
				+ "(ID,ID_CLIENTE,FORMA_DE_PAGAMENTO,VALORTOTAL,ITEM_PEDIDO,DATA)"
				+ " VALUES "
				+ "(?,?,?,?,?,?);";
		
		
		PreparedStatement stmt = conect.criarPreparedStatement(sql);
		ResultSet rs = stmt.getResultSet();
		
		
		try {
			stmt.execute();
			pedido pedidocriado = new pedido();
			pedidocriado.setID(rs.getString("ID"));
			pedidocriado.setCliente(new BuscaID().cliente(rs.getInt("ID_CLIENTE")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return result;
		 

	}
	
	private boolean getCriar(pedido pedido) {
		return criar(pedido);

	}

	public List<BigDecimal> procurarPEDIDOporMES(int mesparabuscar) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BigDecimal> procurarPEDIDOporTELEFONE(String tELEFONEescolhido) {
		// TODO Auto-generated method stub
		return null;
	}

	public pedido buscar(String recebeidPEDIDO) {
		// TODO Auto-generated method stub
		return null;
	}


}
