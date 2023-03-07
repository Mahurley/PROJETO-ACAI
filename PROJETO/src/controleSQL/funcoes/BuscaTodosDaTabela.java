package controleSQL.funcoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import controleSQL.ConexaoBancodeDados;
import telas.item.item;
import telas.abrirpedido.formasdepagamento.PAGAMENTOS;
import telas.buscapedidos.pedido;
import telas.clientes.cliente;

public class BuscaTodosDaTabela {

	

	private List<item> item() {
		ConexaoBancodeDados conect = new ConexaoBancodeDados();

		List<item> lista = new ArrayList<item>();

		conect.getConectar();

		String query = "SELECT * FROM tbItem;";

		Statement stmt = conect.getCriarStatement();
		ResultSet rs = null;

		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				item item = new item();
				item.setId(rs.getInt("ID"));
				item.setNome(rs.getString("NOME"));
				item.setValor(rs.getDouble("VALOR"));
				item.setQuantidade(rs.getInt("QUANTIDADE"));
				lista.add(item);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao buscar ResultSet - item");
			return null;
		} finally {
			try {
				rs.close();
				stmt.close();
				conect.getDesconectar();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Erro close Statement - item");
			}

		}

		return lista;
	}

	private List<cliente> cliente() {

		List<cliente> lista = new ArrayList<cliente>();

		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		conect.getConectar();

		String query = "SELECT * FROM tbCliente;";

		Statement stmt = conect.getCriarStatement();
		ResultSet result = null;
		try {
			result = stmt.executeQuery(query);

			while (result.next()) {
				cliente cliente = new cliente();
				cliente.setId(result.getInt("ID"));
				cliente.setNome(result.getString("NOME"));
				cliente.setDatanascimento(result.getDate("DATA_NASCIMENTO"));
				cliente.setEmail(result.getString("EMAIL"));
				cliente.setTelefone(result.getString("TELEFONE"));
				cliente.setQuantidadePEDIDOS(result.getInt("QUANTIDADE_PEDIDOS"));
				lista.add(cliente);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao buscar ResultSet - cliente");
		} finally {
			try {
				result.close();
				stmt.close();
				conect.getDesconectar();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Erro closed Statement - cliente");
			}
		}

		return lista;
	}

	private List<pedido> pedido() {
		ConexaoBancodeDados conect = new ConexaoBancodeDados();
		pedido pedido = new pedido();
		ResultSet rs = null;
		List<pedido> lista = new ArrayList<pedido>();
		conect.getConectar();

		String sql = "SELECT * FROM tbPedido;";

		Statement stmt = conect.getCriarStatement();
		try {
			stmt.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs = stmt.getResultSet();
			while (rs.next()) {

				cliente cliente = new ProcurarID().cliente("ID", rs.getString("ID_CLIENTE"));
				pedido.setCliente(cliente);
				pedido.setValorTOTAL(rs.getDouble("VALORTOTAL"));
				pedido.setID(rs.getString("ID"));
				pedido.setData(rs.getString("DATA"));
				pedido.setFormaDEpagamento(PAGAMENTOS.valueOf(rs.getString("FORMA_DE_PAGAMENTO")));
				pedido.setTabela(new Gson().fromJson(rs.getString("ITEM_PEDIDO"), new TypeToken<Map<Integer, item>>() {
				}.getType()));
				lista.add(pedido);
				System.out.println("pedido: " + pedido.getID());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conect.getDesconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return lista;

	}

	public List<item> getItem() {
		return item();
	}

	public List<cliente> getCliente() {
		return cliente();
	}

	public List<pedido> getPedido() {
		return pedido();
	}
}
