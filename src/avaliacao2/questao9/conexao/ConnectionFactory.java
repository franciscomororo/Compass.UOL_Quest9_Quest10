package avaliacao2.questao9.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	public Connection recuperarConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/questao9?useTimezone=true&serverTimezone=UTC",
				"root", "12345");

	}

}
