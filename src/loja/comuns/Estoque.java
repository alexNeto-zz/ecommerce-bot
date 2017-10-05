package loja.comuns;

import java.io.Serializable;
import java.util.ArrayList;

public class Estoque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6562678589753507818L;
	private ArrayList<Produtos> estoque = new ArrayList<>();

	public ArrayList<Produtos> getEstoque() {
		return estoque;
	}
	
	public void venda(int i) {
		if(this.estoque.get(i).getQuantidade() > 0)
		this.estoque.get(i).menosUm();
		this.estoque.get(i).maisUm();
	}

	public void setEstoque(Produtos estoque) {
		this.estoque.add(estoque);
	}

}
