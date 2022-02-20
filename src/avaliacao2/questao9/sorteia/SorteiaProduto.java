package avaliacao2.questao9.sorteia;
import avaliacao2.questao9.entidade.Produto;

public class SorteiaProduto {
	
	Produto[] produto = new Produto[15];
	
	public Produto aleatorio(int i) {
		produto[0] = new Produto("Impressora", "Impressora HP", 50);
		produto[1] = new Produto("Impressora", "Impressora 	lexmark", 60);
		produto[2] = new Produto("Tablet", "tablet HP", 70);
		produto[3] = new Produto("Mousepad", "Mousepad Dell", 80);
		produto[4] = new Produto("Impressora", "Impressora Termica", 90);
		produto[5] = new Produto("Mouse", "Mouse Microsoft", 51);
		produto[6] = new Produto("Monitor", "Monitor LG", 52);
		produto[7] = new Produto("Estabilizador", "Estabilizador HP", 53);
		produto[8] = new Produto("Roteador", "Roteador TPlink", 54);
		produto[9] = new Produto("Monitor", "Monitor Samsung", 55);
		produto[10] = new Produto("Impressora", "Impressora Kyocera", 56);
		produto[11] = new Produto("Mouse", "Mouse sem fio", 57);
		produto[12] = new Produto("Base", "Base para Notebook", 58);
		produto[13] = new Produto("Teclado", "Teclado Microsoft", 59);
		produto[14] = new Produto("Placa Mãe", "Placa Mãe XXX", 61);
		
		return produto[i];
		
	}

}
