package controleSQL.criacao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

import controleSQL.funcoes.ProcurarPedido;
import telas.item.item;
import telas.pedido.pedido;

public class CriacaoPedido {
	
	private boolean criar(pedido pedido) {
		Map<Integer,item> map = pedido.getTabela();
		
		String tabelavendas = new Gson().toJson(map);
		
		boolean result = false;
		
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();
		
		String sql = "INSERT OR IGNORE INTO tbPedido "
				+ "(ID,ID_CLIENTE,FORMA_DE_PAGAMENTO,VALORTOTAL,ITEM_PEDIDO,DATA)"
				+ " VALUES "
				+ "(?,?,?,?,?,?);";
		
		
		PreparedStatement stmt = conect.getCriarPreparedStatement(sql);
		
		try {
			stmt.setString(1, pedido.getID());
			stmt.setInt(2, pedido.getCliente().getId());
			stmt.setString(3, pedido.getFormaDEpagamento().toString());
			stmt.setDouble(4, pedido.getValorTOTAL());
			stmt.setString(5, tabelavendas);
			stmt.setTimestamp(6, pedido.getData());

			int resultado = stmt.executeUpdate();
			if (resultado == 1 ) {
				System.out.println("Pedido gravado com sucesso");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				stmt.close();
				result = true;
				conect.getDesconectar();
			} catch (SQLException e) {
				System.out.println("Erro para fechar ResultSet ou Statement - Pedido");
				System.err.println(e.getMessage());
		}
	}
		
		return result;
	
	}
	
	public boolean getCriar(pedido pedido) {
		return criar(pedido);

	}


	public List<String> procurarPEDIDOporTELEFONE(String tELEFONEescolhido) {
		return new ProcurarPedido().porTelefone(tELEFONEescolhido);
	}

	public List<String> procurarPEDIDOporMES(int mesparabuscar) {
		return new ProcurarPedido().porMes(mesparabuscar);
	}



}
