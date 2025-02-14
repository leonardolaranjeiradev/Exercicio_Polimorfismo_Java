package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	private Date dataDeFabricacao;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ProdutoUsado() {
		super();
	}

	public ProdutoUsado(String nome, Double preco, Date dataDeFabricacao) {
		super(nome, preco);
		this.dataDeFabricacao = dataDeFabricacao;
	}

	public Date getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(Date dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}
	
	@Override
	public final String etiquetaDePreco() {
		return nome + " (usado) " + " $ " + String.format("%.2f", preco) + " (Data de fabricação: " + sdf.format(dataDeFabricacao) + ")";
	}


}
