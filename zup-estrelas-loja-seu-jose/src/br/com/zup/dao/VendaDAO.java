package br.com.zup.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.zup.pojo.Peca;

public class VendaDAO {

	private static PecaDAO peca = new PecaDAO();

	List<String> vendas = new ArrayList<String>();

	float valorDaVenda;

	public void venderPeca(int qtdPecas, String codigoDeBarra) throws SQLException {

		Peca pecaVendida = new Peca();
		pecaVendida = peca.consultaPecaPeloCodigo(codigoDeBarra);

		if (pecaVendida.getQtdEmEstoque() < qtdPecas) {
			System.out.println("VENDA NÃO REALIZADA!");

		} else if (pecaVendida.getQtdEmEstoque() >= qtdPecas) {
			System.out.println("VENDA REALIZADA COM SUCESSO!");

			valorDaVenda += qtdPecas * pecaVendida.getPrecoDeCusto();

			vendas.add(pecaVendida.getCodigoDeBarras() + "\t" + pecaVendida.getNome() + "\t\t" + qtdPecas + "\t"
					+ pecaVendida.getPrecoDeCusto());

			int novaQuantidade = pecaVendida.getQtdEmEstoque() - qtdPecas;
			peca.diminuiQtdDePecaVendida(codigoDeBarra,novaQuantidade);

		}
	}

	public void consultarVendas() {
		System.out.println("CÓDIGO" + "\t" + "NOME" + "\t\t" + "QUANTIDADE" + "\t" + "VALOR");
		for (String consulta : vendas) {
			System.out.println(consulta);
		}
		System.out.println("\n");
		System.out.println("TOTAL DE FATURAMENTOS: " + valorDaVenda);
	}

	public void criarRelatorioDeVendas() throws IOException {
		File lojaSeuJose = new File("C:/loja-seu-jose/");
		if (!lojaSeuJose.exists()) {
			lojaSeuJose.mkdir();
		}

		int qtdArquivosLojaSeuJose = lojaSeuJose.listFiles().length;
		qtdArquivosLojaSeuJose++;

		FileWriter fw = new FileWriter("C:/loja-seu-jose/Vendas-Dia" + qtdArquivosLojaSeuJose + ".txt");
		BufferedWriter bw = new BufferedWriter(fw);

		bw.append("\t\t|FECHAMENTO DO DIA|");
		bw.append("\n\r" + "Código" + "\t" + "Nome" + "\t" + "Quantidade" + "\t" + "Valor");
		for (String venda : vendas) {
			bw.append("\r" + venda);
		}
		bw.append("\n\rTotal de Faturamento: R$ " + valorDaVenda);
		bw.close();
		fw.close();
	}

	public void conteudoArquivo(String nomeArquivo, String codigo, String nomePeca, int qtdItens, float valor)
			throws IOException {

		FileWriter writer = new FileWriter(nomeArquivo + ".txt");

		writer.write(codigo + "\t" + nomePeca + "\t\t" + qtdItens + "\t\t" + valor);
		writer.close();
	}

}
