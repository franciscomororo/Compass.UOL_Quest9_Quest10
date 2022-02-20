package avaliacao2.questao10.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import avaliacao2.questao10.dao.EmoticonsDao;
import avaliacao2.questao10.emoticon.Emoticons;
import avaliacao2.questao10.emoticons.conexao.ConnectionFactory;

public class TestaSentimento {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		int contadorDivertido = 0;
		int contadorChateado = 0;
		String emocao;

		System.out.println("Por favor digite uma frase com ou sem emoticons");
		String entrada = sc.nextLine();

		for (int i = 0; i < entrada.length() - 2; i++) {
			if (entrada.charAt(i) == ':') {
				if (entrada.substring(i, i + 3).equals(":-)")) {
					++contadorDivertido;
				}
				if (entrada.substring(i, i + 3).equals(":-(")) {
					++contadorChateado;
				}

			}
		}

		if (contadorDivertido > contadorChateado) {
			emocao = "Divertido";
		} else if (contadorDivertido < contadorChateado) {
			emocao = "Chateado";
		} else {
			emocao = "Neutro";
		}
		

		
		Emoticons emoticons = new Emoticons(emocao);
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			EmoticonsDao emoticonsDao = new EmoticonsDao(connection);
			emoticonsDao.salvar(emoticons);

		}sc.close();

	}

}
