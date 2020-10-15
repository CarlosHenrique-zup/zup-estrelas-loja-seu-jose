package br.com.zup.dao;

import java.util.List;

import br.com.zup.pojo.Peca;

public interface EstoqueDAO {
	
	public List<Peca> consultaTodasAsPecas();
	
	public List<Peca> consultaPecasComencandoPor(String texto);
	
	public List<Peca> consultaPecasPeloModelo(String modeloDoCarro);
	
	public List<Peca> consultaPecasCategoria(String categoria);
	
	public boolean removerPeca(String codigoDeBarra);
	
}
