package avaliacao2.questao10.emoticons.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection recuperarConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/questao10?useTimezone=true&serverTimezone=UTC",
				"root", "12345");

	}


}
