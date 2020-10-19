package br.com.zup.principal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.zup.dao.PecaDAO;
import br.com.zup.dao.VendaDAO;
import br.com.zup.pojo.Peca;

public class ProgramaPrincipal {

	private static PecaDAO peca = new PecaDAO();
	private static VendaDAO venda = new VendaDAO();

	public static final String PULALINHA = "\n";
	public static final String OPCAOINVALIDA = "OPÇÃO INVÁLIDA!";

	public static void menuOpcoes() {
		System.out.println("============================================");
		System.out.println("|          LOJA DE PEÇAS DO SEU JOSÉ	   |");
		System.out.println("============================================");
		System.out.println("|            [ESCOLHA UMA OPÇÃO]           |");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|           [1] - MENU DE PEÇAS            |");
		System.out.println("|           [2] - MENU DE VENDAS           |");
		System.out.println("|           [0] - SAIR DO PROGRAMA         |");
		System.out.println("|                                          |");
		System.out.println("============================================");
	}

	public static void menuVendas() {
		System.out.println("============================================");
		System.out.println("||||||||||||||||||[VENDAS]||||||||||||||||||");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  [1] - VENDER PEÇAS                      |");
		System.out.println("|  [2] - CONSULTA DAS VENDAS DO DIA        |");
		System.out.println("|  [3] - EXTRAIR RELATÓRIO DO DIA          |");
		System.out.println("|  [0] - VOLTAR PARA O MENU PRINCIPAL      |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
	}

	public static void menuPecas() {
		System.out.print(PULALINHA);
		System.out.println("============================================");
		System.out.println("|||||||||||||||||||[PEÇAS]||||||||||||||||||");
		System.out.println("============================================");
		System.out.println("|                                          |");
		System.out.println("|  [1] - CADASTRAR PEÇA                    |");
		System.out.println("|  [2] - CONSULTA PEÇA - CÓDIGO DE BARRA   |");
		System.out.println("|  [3] - LISTAR TODAS AS PEÇAS - ESTOQUE   |");
		System.out.println("|  [4] - LISTAR PEÇAS - LETRA              |");
		System.out.println("|  [5] - LISTAR PEÇAS - MODELO DE CARRO    |");
		System.out.println("|  [6] - LISTAR PEÇAS - CATEGORIA          |");
		System.out.println("|  [7] - REMOVER PEÇA - ESTOQUE            |");
		System.out.println("|  [0] - VOLTAR PARA O MENU PRINCIPAL      |");
		System.out.println("|                                          |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
	}

	public static String metodoCategoria(Scanner sc) {
		int categoriaLida;
		String categoria = null;

		do {
			System.out.println("============================================");
			System.out.println("|              [CATEGORIAS]                |");
			System.out.println("============================================");
			System.out.println("|                                          |");
			System.out.println("|           [1] - FUNILARIA                |");
			System.out.println("|           [2] - MOTOR                    |");
			System.out.println("|           [3] - PERFORMANCE              |");
			System.out.println("|           [4] - SOM                      |");
			System.out.println("|           [5] - ACESSORIOS               |");
			System.out.println("|           [6] - OUTROS                   |");
			System.out.println("|                                          |");
			System.out.println("============================================");
			System.out.print("ENTRE COM O NÚMERO DA CATEGÓRIA: ");
			categoriaLida = sc.nextInt();
			switch (categoriaLida) {
			case 1:
				categoria = Categoria.FUNILARIA.toString();
				break;
			case 2:
				categoria = Categoria.MOTOR.toString();
				break;
			case 3:
				categoria = Categoria.PERFORMANCE.toString();
				break;
			case 4:
				categoria = Categoria.SOM.toString();
				break;
			case 5:
				categoria = Categoria.ACESSORIOS.toString();
				break;
			case 6:
				categoria = Categoria.OUTROS.toString();
				break;
			default:
				System.out.println(OPCAOINVALIDA);
				break;
			}

		} while (categoriaLida != 1 && categoriaLida != 2 && categoriaLida != 3 && categoriaLida != 4
				&& categoriaLida != 5);

		return categoria;
	}

	public static void cadastrarNovasPecas(Scanner sc) throws SQLException {
		System.out.println("============================================");
		System.out.println("|             [CADASTRAR PEÇA]             |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
		System.out.print("INSIRA O CÓDIGO DE BARRAS: ");
		String codigoDeBarras = sc.next();
		System.out.print("INSIRA O NOME DA PEÇA: ");
		String nomeDaPeca = sc.next();
		System.out.print("INSIRA O MODELO DO CARRO: ");
		String modeloDoCarro = sc.next();
		System.out.print("INSIRA O FABRICANTE: ");
		String fabricante = sc.next();
		System.out.print("INSIRA O PRECO DE CUSTO: R$ ");
		float precoDeCusto = sc.nextFloat();
		System.out.print("INSIRA O PRECO DE VENDA: R$ ");
		float precoDeVenda = sc.nextFloat();
		System.out.print("INSIRA A QUANTIDADE EM ESTOQUE: ");
		int qtdEmEstoque = sc.nextInt();

		String categoria = metodoCategoria(sc);

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

		List<Peca> pecas = peca.consultaPecasComencandoPor(nomePeca);

		for (Peca peca : pecas) {
			System.out.println(peca);
		}

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
		List<Peca> pecas = peca.consultaPecasCategoria(metodoCategoria(sc));

		for (Peca pecaCategoria : pecas) {
			System.out.println(pecaCategoria);
		}
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

	public static void realizarVenda(Scanner sc) throws SQLException {
		System.out.println("============================================");
		System.out.println("|             [VENDA DE PEÇAS]             |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
		System.out.println("USUÁRIO, ");
		System.out.print("INSIRA A QUANTIDADE DE PEÇAS: ");
		int qtdPecas = sc.nextInt();
		System.out.print("INSIRA O CÓDIGO DE BARRAS DA PEÇA: ");
		String codigoDeBarras = sc.next();

		venda.venderPeca(qtdPecas, codigoDeBarras);
	}

	public static void consultasDePecasVendidas() {
		venda.consultarVendas();
	}

	public static void dadosDoArquivo(Scanner sc) throws IOException {
		System.out.println("============================================");
		System.out.println("|           [CONTEÚDO DO ARQUIVO]          |");
		System.out.println("============================================");
		System.out.print(PULALINHA);
		System.out.println("USUÁRIO, ");
		System.out.print("INSIRA O NOME DO ARQUIVO: ");
		String nomeDoArquivo = sc.next();
		System.out.print("INSIRA O CÓDIGO DE BARRAS: ");
		String codigoDeBarras = sc.next();
		System.out.print("INSIRA O NOME DA PEÇA: ");
		String nomePeca = sc.next();
		System.out.print("INSIRA A QUANTIDADE DE PEÇAS: ");
		int qtdPecas = sc.nextInt();
		System.out.print("INSIRA O VALOR DA PEÇA: R$ ");
		float valorPeca = sc.nextFloat();

		venda.conteudoArquivo(nomeDoArquivo, codigoDeBarras, nomePeca, qtdPecas, valorPeca);
	}

	public static void finalDoPrograma() {
		System.out.print(PULALINHA);
		System.out.println("============================================");
		System.out.println("|             [FIM DO PROGRAMA]            |");
		System.out.println("============================================");
	}

	public static void opcaoInvalida() {
		System.out.println(PULALINHA);
		System.out.println("===========================================");
		System.out.println("|            [OPÇÃO INVÁLIDA]             |");
		System.out.println("===========================================");
	}

	public static void arquivoCriadoComSucesso() {
		System.out.print(PULALINHA);
		System.out.println("============================================");
		System.out.println("|        [ARQUIVO CRIADO COM SUCESSO]      |");
		System.out.println("============================================");
	}

	public static void main(String[] args) throws SQLException, IOException {

		Scanner sc = new Scanner(System.in);
		final String DETALHAMENTO = "============================================";
		int opcaoUsuario;
		int opcaoMenuPecas;
		int opcaoMenuVendas;

		do {
			menuOpcoes();
			System.out.println(DETALHAMENTO);
			System.out.print("DIGITE UMA OPÇÃO: ");
			opcaoUsuario = sc.nextInt();
			System.out.println(DETALHAMENTO);
			switch (opcaoUsuario) {
			case 1:
				do {
					menuPecas();
					System.out.println(DETALHAMENTO);
					System.out.print("ESCOLHA UM SERVIÇO PARA PEÇAS: ");
					opcaoMenuPecas = sc.nextInt();
					System.out.println(DETALHAMENTO);
					switch (opcaoMenuPecas) {
					case 1:
						try {
							cadastrarNovasPecas(sc);
						} catch (InputMismatchException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						try {
							consultarPeloCodigoDeBarra(sc);
						} catch (InputMismatchException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						try {
							consultasTodasPeçasEstoque(sc);
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
					case 0:
						break;
					default:
						opcaoInvalida();
					}
				} while (opcaoMenuPecas != 0);

				break;
			case 2:

				do {
					System.out.print(PULALINHA);
					menuVendas();
					System.out.println(DETALHAMENTO);
					System.out.print("ESCOLHA O SERVIÇO DE VENDAS: ");
					opcaoMenuVendas = sc.nextInt();
					System.out.println(DETALHAMENTO);
					switch (opcaoMenuVendas) {
					case 1:
						realizarVenda(sc);
						break;
					case 2:
						consultasDePecasVendidas();
						break;
					case 3:
						try {
							venda.criarRelatorioDeVendas();
							arquivoCriadoComSucesso();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 0:
						break;
					default:
						opcaoInvalida();
					}

				} while (opcaoMenuVendas != 0);

				break;
			case 0:

				break;
			}

		} while (opcaoUsuario != 0);

		finalDoPrograma();

		sc.close();
	}
}
