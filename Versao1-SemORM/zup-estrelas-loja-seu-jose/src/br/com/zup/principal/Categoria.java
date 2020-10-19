package br.com.zup.principal;

public enum Categoria {

	FUNILARIA("funilaria"), MOTOR("motor"), PERFORMANCE("performance"), SOM("som"), ACESSORIOS("acessorios"), OUTROS("outros");

	private String descricao;

	Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
