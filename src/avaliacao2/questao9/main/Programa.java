package avaliacao2.questao9.main;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import avaliacao2.questao9.conexao.ConnectionFactory;
import avaliacao2.questao9.dao.ProdutoDao;
import avaliacao2.questao9.entidade.Produto;
import avaliacao2.questao9.sorteia.SorteiaProduto;

public class Programa {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		int opcao = 1;

		while (opcao != 0) {

			System.out.printf("%nDigite a opção desejada: %n");
			System.out.println("Digite 1 - para INSERIR uma nova oferta ");
			System.out.println("Digite 2 - para ATUALIZAR uma oferta ");
			System.out.println("Digite 3 - para DELETAR uma oferta ");
			System.out.println("Digite 4 - para LISTAR as palavras que contem? ");
			System.out.println("Digite 0 - para SAIR ");

			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 1) {
				System.out.println("Digite o Nome: ");
				String nome = sc.nextLine();
				System.out.println("Digite o Descrição: ");
				String descricao = sc.nextLine();
				System.out.println("Digite o desconto: ");
				Double desconto = sc.nextDouble();

				Produto produto = new Produto(nome, descricao, desconto);
				SorteiaProduto sorteiaProduto = new SorteiaProduto();
				Random random = new Random();

				try (Connection connection = new ConnectionFactory().recuperarConexao()) {
					ProdutoDao produtoDao = new ProdutoDao(connection);
					produtoDao.cadastrar(produto);
					produtoDao.cadastrar(sorteiaProduto.aleatorio(random.nextInt(15)));
					produtoDao.cadastrar(sorteiaProduto.aleatorio(random.nextInt(15)));
					produtoDao.cadastrar(sorteiaProduto.aleatorio(random.nextInt(15)));
				}

			} else if (opcao == 2) {
				System.out.println("Digite o ID que deseja atualizar: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o Nome: ");
				String nome = sc.nextLine();
				System.out.println("Digite o Descrição: ");
				String descricao = sc.nextLine();
				System.out.println("Digite o desconto: ");
				Double desconto = sc.nextDouble();
				Produto produto = new Produto(nome, descricao, desconto);

				try (Connection connection = new ConnectionFactory().recuperarConexao()) {
					ProdutoDao produtoDao = new ProdutoDao(connection);
					produtoDao.alterar(produto, id);

				}

			} else if (opcao == 3) {
				System.out.println("Digite o ID que deseja deletar: ");
				int id = sc.nextInt();
				sc.nextLine();
				try (Connection connection = new ConnectionFactory().recuperarConexao()) {
					ProdutoDao produtoDao = new ProdutoDao(connection);
					produtoDao.deletar(id);
				}

			} else if (opcao == 4) {
				System.out.println("Digite a palavra que deseja listar: ");
				String palavra = sc.nextLine();
				try (Connection connection = new ConnectionFactory().recuperarConexao()) {
					ProdutoDao produtoDao = new ProdutoDao(connection);
					produtoDao.listar(palavra);
				}
			}

		}
		sc.close();
		System.out.println("**********FIM*********");
	}
}
