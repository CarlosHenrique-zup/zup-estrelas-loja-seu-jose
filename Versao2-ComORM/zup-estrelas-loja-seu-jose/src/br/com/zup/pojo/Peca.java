package br.com.zup.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="pecas")
public class Peca {

	@Id @Column (name = "codigo_de_barras")
	private String codigoDeBarras;

	private String nome;
	
	@Column (name = "modelo_do_carro")
	private String modeloDoCarro;
	
	private String fabricante;
	
	@Column (name = "preco_de_custo")
	private float precoDeCusto;
	
	@Column (name = "preco_de_venda")
	private float precoDeVenda;
	
	@Column (name = "qtd_em_estoque")
	private int qtdEmEstoque;
	
	private String categoria;

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
		return "Pecas - [codigoDeBarras = " + codigoDeBarras + ", nome = " + nome + ", modeloDoCarro = " + modeloDoCarro
				+ ", fabricante = " + fabricante + ", precoDeCusto = " + precoDeCusto + ", precoDeVenda = "
				+ precoDeVenda + ", qtdEmEstoque = " + qtdEmEstoque + " categoria = " + categoria + "]";
	}

}
