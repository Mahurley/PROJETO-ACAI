package controleSQL;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import controleSQL.funcoes.AlterarValorTabela;
import controleSQL.funcoes.TABELA;
import controleSQL.funcoes.TransformaDATE;
import recursos.transformaSTRINGemDATE;
import telas.clientes.cliente;
import telas.item.item;

public class run extends ConexaoBancodeDados {

	public static void main(String[] args) {
		//ConexaoBancodeDados conexao = new ConexaoBancodeDados();
		//conexao.conectar();
		//new CriacaoCliente().getCriar(new cliente("Maria", new TransformaDATE().preparaDateUtil("14/04/1994"),"meuemail@gmail.com" ,"11912121212"));
		//new CriacaoItem().getCriar(new item());
		//cliente retorno = new BuscaID().cliente(1);
		//System.out.println(retorno.getNome());
		//conexao.desconectar();
		//new TransformaDATE().preparaDateSQL("14/04/1994");
		//System.out.println(controleSQL.funcoes.TABELA.CLIENTE.getCaminho());
		new AlterarValorTabela().executar(TABELA.CLIENTE, "\"QUANTIDADE_PEDIDOS\"", "'2'", "\"ID\"", "'2'");
	}

}
