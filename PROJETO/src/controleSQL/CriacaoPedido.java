package controleSQL;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import controleSQL.funcoes.BuscaID;
import telas.buscapedidos.pedido;

public class CriacaoPedido {
	
	private boolean criar(pedido pedido) {
		boolean result = false;
		
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();
		
		String sql = "INSERT OR IGNORE INTO tbPedido "
				+ "(ID,ID_CLIENTE,FORMA_DE_PAGAMENTO,VALORTOTAL,ITEM_PEDIDO,DATA)"
				+ " VALUES "
				+ "(?,?,?,?,?,?);";
		
		
		PreparedStatement stmt = conect.getCriarPreparedStatement(sql);
		ResultSet rs = null;
		
		
		try {
			rs = stmt.getResultSet();
			stmt.execute();
			pedido pedidocriado = new pedido();
			pedidocriado.setID(rs.getString("ID"));
			pedidocriado.setCliente(new BuscaID().cliente(rs.getInt("ID_CLIENTE")));
			
		} catch (SQLException e) {
			System.out.println("Erro com ResultSet ou Statement - Pedido");
			System.err.println(e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Erro para fechar ResultSet ou Statement - Pedido");
				System.err.println(e.getMessage());
			}
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
