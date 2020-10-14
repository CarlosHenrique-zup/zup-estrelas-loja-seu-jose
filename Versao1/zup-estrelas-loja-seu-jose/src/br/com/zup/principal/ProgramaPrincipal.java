package br.com.zup.principal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.zup.dao.PecaDAO;
import br.com.zup.pojo.Peca;

public class ProgramaPrincipal {

	private static PecaDAO peca = new PecaDAO();

	public static void menuOpcao() {
		System.out.println("============================================");
		System.out.println("|||||||||||||||||||[PEÇAS]||||||||||||||||||");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  [1] - CADASTRAR PEÇA                    |");
		System.out.println("|  [2] - CONSULTA PEÇA - CÓDIGO DE BARRA   |");
		System.out.println("|  [3] - LISTAR PEÇAS - ESTOQUE            |");
		System.out.println("|  [4] - LISTAR PEÇAS - LETRA              |");
		System.out.println("|  [5] - LISTAR PEÇAS - MODELO DE CARRO    |");
		System.out.println("|  [6] - LISTAR PEÇAS - CATEGORIA          |");
		System.out.println("|  [7] - REMOVER PEÇA - ESTOQUE            |");
		System.out.println("|  [8] - MENU PRINCIPAL                    |");
		System.out.println("|  [0] - SAIR DO PROGRAMA                  |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.print("\n");
	}

	public static void cadastrarNovasPecas(Scanner sc) throws SQLException {
		System.out.println("============================================");
		System.out.println("|             [CADASTRAR PEÇA]             |");
		System.out.println("============================================");
		System.out.print("\n");
		System.out.print("CÓDIGO DE BARRAS: ");
		String codigoDeBarras = sc.next();
		System.out.println("NOME DA PEÇA: ");
		String nomeDaPeca = sc.next();
		System.out.print("MODELO DO CARRO: ");
		String modeloDoCarro = sc.next();
		System.out.print("FABRICANTE: ");
		String fabricante = sc.next();
		System.out.print("PRECO DE CUSTO: ");
		float precoDeCusto = sc.nextFloat();
		System.out.print("PRECO DE VENDA: ");
		float precoDeVenda = sc.nextFloat();
		System.out.print("QUANTIDADE EM ESTOQUE: ");
		int qtdEmEstoque = sc.nextInt();

		String categoria = null;

		int opcao;
		do {

			System.out.println("|[CATEGORIAS]|");
			System.out.println("[1] - FUNILARIA ");
			System.out.println("[2] - MOTOR");
			System.out.println("[3] - PERFORMANCE");
			System.out.println("[4] - SOM");

			System.out.println("DIGITE UMA OPÇÃO: ");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				categoria = "funilaria";
				break;
			case 2:
				categoria = "motor";
				break;
			case 3:
				categoria = "performance";
				break;
			case 4:
				categoria = "som";
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
		} while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4);

		peca.cadastrarNovaPeca(new Peca(codigoDeBarras, nomeDaPeca, modeloDoCarro, fabricante, precoDeCusto,
				precoDeVenda, qtdEmEstoque, categoria));

	}

	public static void consultarPeloCodigoDeBarra(Scanner sc) throws SQLException {
		System.out.println("============================================");
		System.out.println("|     [CONSULTA PELO CÓDIGO DE BARRA]      |");
		System.out.println("============================================");
		System.out.println("USUÁRIO, ");
		System.out.print("INSIRA O CÓDIGO DE BARRA: ");
		String codigoDeBarra = sc.next();

		System.out.println(peca.consultaPecaPeloCodigo(codigoDeBarra));
	}

	public static void consultasTodasPeçasEstoque(Scanner sc) {
		List<Peca> pecas = peca.consultaTodasAsPecas();
		System.out.println("============================================");
		System.out.println("|        [CONSULTAR TODAS AS PEÇAS]        |");
		System.out.println("============================================");

		for (Peca pecasEmEstoque : pecas) {
			System.out.println(pecasEmEstoque);
		}
	}

	public static void consultarPecasPelaLetra(Scanner sc) {
		System.out.println("============================================");
		System.out.println("|        [ESCOLHA UM NOME DA PEÇA]         |");
		System.out.println("============================================");
		System.out.println("USUÁRIO, ");
		System.out.print("INSIRA O NOME DA PEÇA: ");
		String nomePeca = sc.next();

		peca.consultaPecasComencandoPor(nomePeca);
	}

	public static void consultarPecasPeloModelo(Scanner sc) {
		System.out.println("============================================");
		System.out.println("|  [CONSULTAR PEÇAS PELO MODELO DE CARRO]  |");
		System.out.println("============================================");
		System.out.println("USUÁRIO, ");
		System.out.print("INSIRA O MODELO DO CARRO: ");
		String modeloDoCarro = sc.next();

		List<Peca> pecas = peca.consultaPecasPeloModelo(modeloDoCarro);

		for (Peca peca : pecas) {
			System.out.println(peca);
		}
	}

	public static void consultarPecaPelaCategoria(Scanner sc) {
		System.out.println("============================================");
		System.out.println("|      [CONSULTA PEÇA PELA CATEGORIA]      |");
		System.out.println("============================================");
		System.out.println("USUÁRIO, ");
		System.out.print("INSIRA A CATEGORIA: ");
		String categoria;
//		Categoria categoria = Categoria.valueOf(sc.next());

		List<Peca> list = new ArrayList<>();
//		list.add(new Peca(categoria));

		int opcao;
		do {
			System.out.println("============================================");
			System.out.println("|              [CATEGORIAS]                |");
			System.out.println("============================================");
			System.out.println("[1] - FUNILARIA ");
			System.out.println("[2] - MOTOR");
			System.out.println("[3] - PERFORMANCE");
			System.out.println("[4] - SOM");

			System.out.println("DIGITE UMA OPÇÃO: ");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				categoria = "funilaria";
				break;
			case 2:
				categoria = "motor";
				break;
			case 3:
				categoria = "performance";
				break;
			case 4:
				categoria = "som";
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
		} while (opcao != 1 || opcao != 2 || opcao != 3 || opcao != 4);

	}

	public static void removerPeca(Scanner sc) {
		System.out.println("============================================");
		System.out.println("|    [REMOVER PEÇA PELO CÓDIGO DE BARRA]   |");
		System.out.println("============================================");
		System.out.println("USUÁRIO, ");
		System.out.print("INSIRA O CÓDIGO DE BARRA: ");
		String codigoDeBarra = sc.next();

		peca.removerPeca(codigoDeBarra);
	}

	public static void finalDoPrograma() {
		System.out.print("\n");
		System.out.println("============================================");
		System.out.println("|             [FIM DO PROGRAMA]            |");
		System.out.println("============================================");
	}

	public static void opcaoInvalida() {
		System.out.println("\n");
		System.out.println("===========================================");
		System.out.println("|            [OPÇÃO INVÁLIDA]             |");
		System.out.println("===========================================");
	}

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		final String DETALHAMENTO = "============================================";
		int opcaoUsuario;

		menuOpcao();
		do {
			System.out.println(DETALHAMENTO);
			System.out.print("DIGITE UMA OPÇÃO: ");
			opcaoUsuario = sc.nextInt();
			System.out.println(DETALHAMENTO);
			switch (opcaoUsuario) {
			case 1:
				try {
					cadastrarNovasPecas(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					consultasTodasPeçasEstoque(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					consultarPeloCodigoDeBarra(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					consultarPecasPelaLetra(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					consultarPecasPeloModelo(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				try {
					consultarPecaPelaCategoria(sc);
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				removerPeca(sc);
				break;
			case 8:
				menuOpcao();
				break;
			case 0:
				finalDoPrograma();
				break;
			default:
				opcaoInvalida();
			}

		} while (opcaoUsuario != 0);

		sc.close();
	}
}
