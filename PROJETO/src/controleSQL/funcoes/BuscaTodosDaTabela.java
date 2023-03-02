package controleSQL.funcoes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controleSQL.ConexaoBancodeDados;
import telas.item.item;
import telas.clientes.cliente;

public class BuscaTodosDaTabela {

	ConexaoBancodeDados conect = new ConexaoBancodeDados();

	private List<item> item() {

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
				System.out.println(item);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao buscar ResultSet - item");
			return null;
		}finally {
			try {
				rs.close();
				stmt.close();
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
				cliente.setDatanascimento(new TransformaDATE().preparaDateUtil(new TransformaDATE().StringParaDateSQL(result.getString("DATA_NASCIMENTO"))));
				cliente.setEmail(result.getString("EMAIL"));
				cliente.setTelefone(result.getString("TELEFONE"));
				cliente.setQuantidadePEDIDOS(result.getInt("QUANTIDADE_PEDIDOS"));
				lista.add(cliente);
				System.out.println(cliente);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Erro ao buscar ResultSet - cliente");
		}finally {
			try {
				result.close();
				stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Erro closed Statement - cliente");
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
}
