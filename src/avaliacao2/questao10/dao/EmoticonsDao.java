package avaliacao2.questao10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import avaliacao2.questao10.emoticon.Emoticons;

public class EmoticonsDao {

	private Connection connection;

	public EmoticonsDao(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Emoticons emoticons) throws SQLException {
		String sql = "INSERT INTO SENTIMENTO (emocao) VALUES(?)";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, emoticons.getEmocao());
			pstm.execute();

			try (ResultSet rs = pstm.getGeneratedKeys()) {
				while (rs.next()) {
					emoticons.setId(rs.getInt(1));
				}
			}
		}

	}

}
