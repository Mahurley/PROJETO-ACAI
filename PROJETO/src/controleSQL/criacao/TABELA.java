package controleSQL.criacao;

public enum TABELA {
	
	CLIENTE("tbCliente"),
	ITEM("tbItem"),
	PEDIDO("tbPedido");
	
	private String caminho;

	private TABELA(String caminho) {
		this.caminho = caminho;
	}

	public String getCaminho() {
		return caminho;
	}

}
