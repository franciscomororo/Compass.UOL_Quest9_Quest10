package avaliacao2.questao9.entidade;
import java.time.LocalDate;

public class Produto {

	private int id;
	private String nome;
	private String descricao;
	private double desconto;
	private LocalDate dataInicio;

	public Produto(String nome, String descricao, double desconto) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = desconto;
		this.dataInicio = LocalDate.now();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

}
