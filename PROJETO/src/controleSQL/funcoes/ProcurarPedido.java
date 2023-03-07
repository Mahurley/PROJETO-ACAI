package controleSQL.funcoes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controleSQL.ConexaoBancodeDados;
import telas.abrirpedido.formasdepagamento.PAGAMENTOS;
import telas.buscapedidos.pedido;
import telas.clientes.cliente;
import telas.item.item;

public class ProcurarPedido {


	public List<String> porTelefone(String telefone) {
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		pedido pedido = new pedido();
		ResultSet rs = null;
		List<String> listaCOMpedidos = new ArrayList<String>();

		conect.getConectar();

		cliente cliente = new ProcurarID().cliente("TELEFONE", telefone);

		String sql = "SELECT * FROM tbPedido WHERE ID_CLIENTE = ? ;";

		PreparedStatement stmt = conect.getCriarPreparedStatement(sql);

		try {
			stmt.setString(1, String.valueOf(cliente.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				pedido.setCliente(cliente);
				pedido.setFormaDEpagamento(PAGAMENTOS.valueOf(rs.getString("FORMA_DE_PAGAMENTO")));
				pedido.setID(rs.getString("ID"));
				pedido.setTabela(new Gson().fromJson(rs.getString("ITEM_PEDIDO"), new TypeToken<Map<Integer, item>>() {	}.getType()));
				pedido.setValorTOTAL(rs.getDouble("VALORTOTAL"));
				pedido.setData(rs.getString("DATA"));
				listaCOMpedidos.add(pedido.getID());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaCOMpedidos;
	}

	public pedido porID(String ID) {
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		pedido pedido = new pedido();
		ResultSet rs = null;
		List<String> listaCOMpedidos = new ArrayList<String>();
		conect.getConectar();

		String sql = "SELECT * FROM tbPedido WHERE ID = ? ;";

		PreparedStatement stmt = conect.getCriarPreparedStatement(sql);

		try {
			stmt.setString(1, ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			rs = stmt.executeQuery();
			cliente cliente = new ProcurarID().cliente("ID", rs.getString("ID_CLIENTE"));
			pedido.setCliente(cliente);
			pedido.setFormaDEpagamento(PAGAMENTOS.valueOf(rs.getString("FORMA_DE_PAGAMENTO")));
			pedido.setID(rs.getString("ID"));
			pedido.setTabela(new Gson().fromJson(rs.getString("ITEM_PEDIDO"), new TypeToken<Map<Integer, item>>() {
			}.getType()));
			pedido.setValorTOTAL(rs.getDouble("VALORTOTAL"));
			pedido.setData(rs.getString("DATA"));
			listaCOMpedidos.add(pedido.getID());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pedido;
	}
}
