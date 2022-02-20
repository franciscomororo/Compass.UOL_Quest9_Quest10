package avaliacao2.questao9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import avaliacao2.questao9.entidade.Produto;

public class ProdutoDao {

	private Connection connection;
	private DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public ProdutoDao(Connection connection) {

		this.connection = connection;
	}

	public void cadastrar(Produto produto) throws SQLException {
		String sql = "INSERT INTO Produto (nome, descricao, desconto, data_inicio) VALUES(?, ?, ?, ?)";
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getDesconto());
			pstm.setString(4, produto.getDataInicio().format(data));

			pstm.execute();

			try (ResultSet rs = pstm.getGeneratedKeys()) {
				while (rs.next()) {
					produto.setId(rs.getInt(1));
				}
			}

		}

	}

	public void deletar(int id) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
			pstm.setInt(1, id);
			pstm.execute();
			if (pstm.getUpdateCount() > 0) {
				System.out.println("Produto deletado!");
			} else
				System.out.println("Digite um ID válido");

		}

	}

	public void listar(String dado) throws SQLException {
		String sql = "SELECT * FROM PRODUTO WHERE descricao  LIKE '%" + dado + "%'";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();

			ResultSet rs = pstm.getResultSet();
			while (rs.next()) {
				System.out.println("ID:" + rs.getInt("id") + "-" + rs.getString("descricao"));

			}
		}

	}

	public void alterar(Produto produto, int id) throws SQLException {
		String sql = "UPDATE PRODUTO SET nome=?, descricao=?, desconto=?, data_inicio=? WHERE ID=? ";
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getDesconto());
			pstm.setString(4, produto.getDataInicio().format(data));
			pstm.setInt(5, id);
			pstm.execute();

			if (pstm.getUpdateCount() > 0) {
				System.out.println("Produto atualizado com sucesso");
			} else {
				cadastrar(produto);
			}
		}
	}
}
