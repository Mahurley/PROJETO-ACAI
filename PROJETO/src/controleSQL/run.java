package controleSQL;

public class run extends ConexaoBancodeDados {

	public static void main(String[] args) {
		ConexaoBancodeDados conexao = new ConexaoBancodeDados();
		conexao.conectar();
		conexao.desconectar();
	}

}
