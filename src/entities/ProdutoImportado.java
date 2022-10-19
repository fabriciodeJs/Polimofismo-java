package entities;

public class ProdutoImportado extends Produto{
	
	private Double taxaAlfandega;
	
	public ProdutoImportado () {
		super();
	}

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	@Override
	public String etiquetaDePreco() {
		return super.getNome() + " $ " + String.format("%.2f", precoTotal()) 
		+ " (Taxa de importacao $" + taxaAlfandega + " )";
	}
	public Double precoTotal(){
		return super.getPreco() + taxaAlfandega;
	}
}
