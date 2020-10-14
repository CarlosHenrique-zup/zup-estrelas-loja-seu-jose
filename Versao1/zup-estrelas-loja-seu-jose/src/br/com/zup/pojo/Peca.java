package br.com.zup.pojo;

import br.com.zup.principal.Categoria;

public class Peca {

	String codigoDeBarras;
	String nome;
	String modeloDoCarro;
	String fabricante;
	float precoDeCusto;
	float precoDeVenda;
	int qtdEmEstoque;
	String categoria;

	public Peca() {

	}

	public Peca(String codigoDeBarras, String nome, String modeloDoCarro, String fabricante, float precoDeCusto,
			float precoDeVenda, int qtdEmEstoque, String categoria) {
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.modeloDoCarro = modeloDoCarro;
		this.fabricante = fabricante;
		this.precoDeCusto = precoDeCusto;
		this.precoDeVenda = precoDeVenda;
		this.categoria = categoria;
		this.qtdEmEstoque = qtdEmEstoque;
	}
	

	public Peca(String codigoDeBarras, String nome, String modeloDoCarro, String fabricante, float precoDeCusto,
			float precoDeVenda, int qtdEmEstoque) {
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.modeloDoCarro = modeloDoCarro;
		this.fabricante = fabricante;
		this.precoDeCusto = precoDeCusto;
		this.precoDeVenda = precoDeVenda;
		this.qtdEmEstoque = qtdEmEstoque;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModeloDoCarro() {
		return modeloDoCarro;
	}

	public void setModeloDoCarro(String modeloDoCarro) {
		this.modeloDoCarro = modeloDoCarro;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public float getPrecoDeCusto() {
		return precoDeCusto;
	}

	public void setPrecoDeCusto(float precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}

	public float getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(float precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public int getQtdEmEstoque() {
		return qtdEmEstoque;
	}

	public void setQtdEmEstoque(int qtdEmEstoque) {
		this.qtdEmEstoque = qtdEmEstoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Pecas [codigoDeBarras=" + codigoDeBarras + ", nome=" + nome + ", modeloDoCarro=" + modeloDoCarro
				+ ", fabricante=" + fabricante + ", precoDeCusto=" + precoDeCusto + ", precoDeVenda=" + precoDeVenda
				+ ", qtdEmEstoque=" + qtdEmEstoque + "]";
	}

	

}
