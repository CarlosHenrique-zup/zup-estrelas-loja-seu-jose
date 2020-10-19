package br.com.zup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.zup.pojo.Peca;

public class PecaDAO {

	EntityManager manager;

	public PecaDAO() {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("pecas");
		this.manager = managerFactory.createEntityManager();
		System.out.println("Conectado");
	}

//	public static void pecaRemovida() {
//		System.out.print("\n");
//		System.out.println("=============================================");
//		System.out.println("|       [PEÇA REMOVIDA COM SUCESSO!!!]      |");
//		System.out.println("=============================================");
//	}
//

	public void cadastrarNovaPeca(Peca pecas) {
		manager.getTransaction().begin();
		manager.persist(pecas);
		manager.getTransaction().commit();
	}

//
	public Peca consultaPecaPeloCodigo(String codigoLido) {
		Peca pecaConsultada = manager.find(Peca.class, codigoLido);

		return pecaConsultada;
	}
//

	public List<Peca> consultaTodasAsPecas() {

		Query query = manager.createQuery("select p from Peca as p");

		List<Peca> pecas = query.getResultList();

		return pecas;
	}

//
	public List<Peca> consultaPecasComencandoPor(String texto) {
		Query queryLetra = manager.createQuery("select p from Peca as p WHERE p.nome LIKE :palavra");

		queryLetra.setParameter("palavra", texto + "%");

		List<Peca> pecas = queryLetra.getResultList();

		return pecas;

	}

	public List<Peca> consultaPecasPeloModelo(String modeloDoCarro) {
		Query queryModelo = manager.createQuery("select p from Peca as p WHERE p.modeloDoCarro = :modeloDocarro");

		queryModelo.setParameter("modeloDocarro", modeloDoCarro);

		List<Peca> pecas = queryModelo.getResultList();

		return pecas;
	}

//
	public List<Peca> consultaPecasCategoria(String categoria) {
		Query queryCategoria = manager.createQuery("select p from Peca as p WHERE p.categoria = :categoria");

		queryCategoria.setParameter("categoria", categoria);

		List<Peca> pecasCategoria = queryCategoria.getResultList();

		return pecasCategoria;
	}

//
	public void removerPeca(String codigoDeBarra) {
		Peca peca = manager.find(Peca.class, codigoDeBarra);

		manager.getTransaction().begin();
		manager.remove(peca);
		manager.getTransaction().commit();

	}

	public void diminuiQtdDePecaVendida(String codigoDeBarras, int novaQtd) {

		Peca peca = manager.find(Peca.class, codigoDeBarras);

		peca.setQtdEmEstoque(novaQtd);
		manager.getTransaction().begin();
		manager.merge(peca);
		manager.getTransaction().commit();

	}

}
