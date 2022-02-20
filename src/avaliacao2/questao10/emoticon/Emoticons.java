package avaliacao2.questao10.emoticon;

public class Emoticons {

	private int id;
	private String emocao;

	public Emoticons(String emocao) {
		this.emocao = emocao;
	}

	public String getEmocao() {
		return emocao;
	}

	public void setEmocao(String emocao) {
		this.emocao = emocao;
	}

	public void setId(int id) {
		this.id = id;
	}

}