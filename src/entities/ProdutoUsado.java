package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto{
		
	private Date dataDeFabricacao;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
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
	public String etiquetaDePreco () {
		return super.getNome() + " (USADO) $ " + super.getPreco() 
				+ " ( DATA DE FABRICAO " + sdf.format(dataDeFabricacao) + " )";
	}
}
