package controleSQL.funcoes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import controleSQL.criacao.ConexaoBancodeDados;
import telas.clientes.cliente;
import telas.item.item;
import telas.pedido.pedido;
import telas.pedido.FormaDePagamento.PAGAMENTOS;

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
			System.out.println("Erro usar ID - ProcurarPedido");
			System.out.println(e.getMessage());
		}

		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				pedido.setCliente(cliente);
				pedido.setFormaDEpagamento(PAGAMENTOS.valueOf(rs.getString("FORMA_DE_PAGAMENTO")));
				pedido.setID(rs.getString("ID"));
				pedido.setTabela(new Gson().fromJson(rs.getString("ITEM_PEDIDO"), new TypeToken<Map<Integer, item>>() {
				}.getType()));
				pedido.setValorTOTAL(rs.getDouble("VALORTOTAL"));
				pedido.setData(rs.getTimestamp("DATA"));
				listaCOMpedidos.add(pedido.getID());
			}

		} catch (SQLException e) {
			System.out.println("Erro procurar - ProcurarPedido");
			System.out.println(e.getMessage());
		} finally {
			try {
				stmt.close();
				rs.close();
				conect.getDesconectar();
			} catch (SQLException e) {
				System.out.println("Erro .close ProcurarPedido - ProcurarPedido");
				System.out.println(e.getMessage());
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
			System.out.println("Erro procurar - ProcurarPedido ID");
			System.out.println(e.getMessage());
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
			pedido.setData(rs.getTimestamp("DATA"));
			listaCOMpedidos.add(pedido.getID());

		} catch (SQLException e) {
			System.out.println("Erro procurar - ProcurarPedido ID");
			System.out.println(e.getMessage());
		} finally {
			try {
				stmt.close();
				rs.close();
				conect.getDesconectar();
			} catch (SQLException e) {
				System.out.println("Erro .closed porID - ProcurarPedido");
				System.out.println(e.getMessage());
			}
		}
		return pedido;
	}

	public List<String> porMes(int mesparabuscar) {
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();

		List<String> pedidosSelecionados = new ArrayList<String>();

		String sql = "SELECT * FROM tbPedido WHERE strftime('%m', DATA) = ? ;";

		PreparedStatement stmt = conect.getCriarPreparedStatement(sql);

		try {
			stmt.setInt(1, mesparabuscar);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				pedido pedido = new pedido();
				pedido.setValorTOTAL(rs.getDouble("VALORTOTAL"));
				pedido.setID(rs.getString("ID"));
				pedido.setFormaDEpagamento(PAGAMENTOS.valueOf(rs.getString("FORMA_DE_PAGAMENTO")));
				pedido.setCliente(new ProcurarID().cliente("ID", rs.getString("ID")));
				pedido.setData(rs.getTimestamp("DATA"));
				pedido.setTabela(new Gson().fromJson(rs.getString("ITEM_PEDIDO"), new TypeToken<Map<Integer, item>>() {
				}.getType()));
				pedidosSelecionados.add(pedido.getID());
				System.out.println("Pedido encontrado: " + pedido.getID());

			}

		} catch (SQLException e) {
			System.out.println("Erro busca porMES - ProcurarPedido");
			System.out.println(e.getMessage());
		} finally {
			try {
				stmt.close();
				conect.getDesconectar();
				return pedidosSelecionados;
			} catch (SQLException e) {
				System.out.println("Erro .close porMES - ProcurarPedido");
				System.out.println(e.getMessage());
			}
		}

		return null;
	}
}
