package br.com.zup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.factory.ConnectionFactory;
import br.com.zup.pojo.Peca;
import br.com.zup.principal.Categoria;

public class PecaDAO implements EstoqueDAO {

	private Connection connection;

	public PecaDAO() {
		new ConnectionFactory();
		this.connection = ConnectionFactory.fabricaConexao();
	}

	public static void pecaRemovida() {
		System.out.print("\n");
		System.out.println("=============================================");
		System.out.println("|       [PEÇA REMOVIDA COM SUCESSO!!!]      |");
		System.out.println("=============================================");
	}

	private static void whilePadraoPecas(ResultSet rs, List<Peca> pecas) throws SQLException {

		while (rs.next()) {

			Peca peca = new Peca();
			peca.setCodigoDeBarras(rs.getString("codigo_de_barras"));
			peca.setNome(rs.getString("nome"));
			peca.setModeloDoCarro(rs.getString("modelo_do_carro"));
			peca.setFabricante(rs.getString("fabricante"));
			peca.setPrecoDeCusto(rs.getFloat("preco_de_custo"));
			peca.setPrecoDeVenda(rs.getFloat("preco_de_venda"));
			peca.setQtdEmEstoque(rs.getInt("qtd_em_estoque"));

			pecas.add(peca);
		}
	}

	public boolean cadastrarNovaPeca(Peca pecas) throws SQLException {
		String sqlInsercao = "insert into estoque.pecas "
				+ "(codigo_de_barras, nome, modelo_do_carro, fabricante, preco_de_custo, preco_de_venda, qtd_em_estoque) "
				+ "values (?,?,?,?,?,?,?); ";

		PreparedStatement instrucao = connection.prepareStatement(sqlInsercao);
		instrucao.setString(1, pecas.getCodigoDeBarras());
		instrucao.setString(2, pecas.getNome());
		instrucao.setString(3, pecas.getModeloDoCarro());
		instrucao.setString(4, pecas.getFabricante());
		instrucao.setDouble(5, pecas.getPrecoDeCusto());
		instrucao.setDouble(6, pecas.getPrecoDeVenda());
		instrucao.setInt(7, pecas.getQtdEmEstoque());

		instrucao.execute();
		instrucao.close();
		System.out.println("Banco Conectado!");
		System.out.println("Informações Inseridas!");
//		connection.close();
		return true;
	}

	public Peca consultaPecaPeloCodigo(String codigoLido) throws SQLException {

		Peca pecaConsultada = new Peca();
		String sql = "SELECT p.* FROM estoque.pecas p WHERE p.codigo_de_barras = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, codigoLido);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Peca pecaPesquisada = new Peca();

				pecaPesquisada.setCodigoDeBarras(rs.getString("codigo_de_barras"));
				pecaPesquisada.setNome(rs.getString("nome"));
				pecaPesquisada.setModeloDoCarro(rs.getString("modelo_do_carro"));
				pecaPesquisada.setFabricante(rs.getString("fabricante"));
				pecaPesquisada.setPrecoDeCusto(rs.getFloat("preco_de_custo"));
				pecaPesquisada.setPrecoDeVenda(rs.getFloat("preco_de_venda"));
				pecaPesquisada.setQtdEmEstoque(rs.getInt("qtd_em_estoque"));

				pecaConsultada = pecaPesquisada;
			}

		} catch (SQLException e) {
			System.err.println("erro!");
			e.printStackTrace();
		}
		return pecaConsultada;

	}

	public List<Peca> consultaTodasAsPecas() {
		List<Peca> pecas = new ArrayList<>();

		String sql = "SELECT * FROM pecas";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			whilePadraoPecas(rs, pecas);

			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro ao listar todas as peças no estoque!");
			e.printStackTrace();
		}

		return pecas;
	}

	public List<Peca> consultaPecasComencandoPor(String texto) {
		List<Peca> pecas = new ArrayList<>();

		String sql = "SELECT * FROM pecas WHERE nome like ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, texto + '%');

			ResultSet rs = stmt.executeQuery();

			whilePadraoPecas(rs, pecas);

			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro ao listar as peças por início do nome!");
			e.printStackTrace();
		}

		return pecas;
	}

	public List<Peca> consultaPecasPeloModelo(String modeloDoCarro) {
		List<Peca> pecas = new ArrayList<>();

		String sql = "SELECT p.* " + "FROM estoque.pecas p " + "WHERE modelo_do_carro = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, modeloDoCarro);
			ResultSet rs = stmt.executeQuery();
			whilePadraoPecas(rs, pecas);

			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro ao buscar pecas!");
			System.out.println(e.getMessage());
			return pecas;
		}

		return pecas;
	}

	public List<Peca> consultaPecasCategoria(String categoria) {
		List<Peca> pecas = new ArrayList<>();

		String sql = "SELECT * FROM pecas WHERE categoria = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, categoria);

			ResultSet rs = stmt.executeQuery();

			whilePadraoPecas(rs, pecas);

			stmt.close();

		} catch (SQLException e) {
			System.out.println("Erro ao listar as peças por cotegoria!");
			e.printStackTrace();
		}

		return pecas;
	}

	public boolean removerPeca(String codigoDeBarra) {
		String sqlRemover = "DELETE FROM pecas WHERE codigo_de_barras = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlRemover);
			stmt.setString(1, codigoDeBarra);
			pecaRemovida();
			return stmt.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao deletar peça!");
			System.out.println(e.getMessage());
			return false;
		}

	}
	
	public void diminuiQtdDePecaVendida(String codigoDeBarras, int novaQtd) throws SQLException {
		
		String sqlQtdPecas = "UPDATE estoque.pecas SET qtd_em_estoque = ? WHERE codigo_de_barras = ? ";
		
		PreparedStatement instrucao = connection.prepareStatement(sqlQtdPecas);
		instrucao.setInt(1, novaQtd);
		instrucao.setString(2, codigoDeBarras);
		
	
		instrucao.execute();
		instrucao.close();
	}

}
