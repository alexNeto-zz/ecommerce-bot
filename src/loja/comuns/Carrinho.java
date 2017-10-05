package loja.comuns;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrinho implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2945961068642949168L;
	private ArrayList<Produtos> comprados = new ArrayList<>();

	
	public double total() {
		double total = 0;
		for(Produtos produto: comprados) {
			total += produto.getPreco();
		}
		return total;
	}
	public ArrayList<Produtos> getComprados() {
		return comprados;
	}

	public void setComprados(Produtos comprados) {
		this.comprados.add(comprados);
	}
	
	
	
	

}
