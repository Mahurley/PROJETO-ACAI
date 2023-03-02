package controleSQL;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import telas.clientes.cliente;
import telas.item.item;

public class run extends ConexaoBancodeDados {

	public static void main(String[] args) {
		//ConexaoBancodeDados conexao = new ConexaoBancodeDados();
		//conexao.conectar();
		//new CriacaoCliente().getCriar(new cliente("Maria", "14/04/1994","meuemail@gmail.com" ,"11912121212"));
		//new CriacaoItem().getCriar(new item());
		//cliente retorno = new BuscaID().cliente(1);
		//System.out.println(retorno.getNome());
		//conexao.desconectar();
		new TransformaDATE();
	}

}
